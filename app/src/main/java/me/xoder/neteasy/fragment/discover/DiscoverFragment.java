package me.xoder.neteasy.fragment.discover;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;

import me.xoder.neteasy.R;

/**
 * Created by alex.lee on 2015-07-25.
 */
public class DiscoverFragment extends Fragment implements View.OnClickListener {
	private Context context;
	private int lastViewId;

	private CheckedTextView ctvAdvise;
	private CheckedTextView ctvSongList;
	private CheckedTextView ctvAnchorStation;
	private CheckedTextView ctvRankingList;

	private Fragment fgTo;
	private Fragment fgAdvise;
	private Fragment fgAnchor;
	private Fragment fgRanking;
	private Fragment fgSong;


	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		context = activity;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_discover, container, false);
		initViews(view);
		return view;
	}
	
	private void initViews(View view) {
		ctvAdvise = (CheckedTextView) view.findViewById(R.id.ctv_advise);
		ctvSongList = (CheckedTextView) view.findViewById(R.id.ctv_song_list);
		ctvAnchorStation = (CheckedTextView) view.findViewById(R.id.ctv_anchor_station);
		ctvRankingList = (CheckedTextView) view.findViewById(R.id.ctv_ranking_list);

		ctvAdvise.setOnClickListener(this);
		ctvSongList.setOnClickListener(this);
		ctvAnchorStation.setOnClickListener(this);
		ctvRankingList.setOnClickListener(this);

		if (fgAdvise == null) {
			fgAdvise = new AdviseFragment();
		}
		if (!fgAdvise.isAdded()) {
			getChildFragmentManager().beginTransaction().add(R.id.frame_container, fgAdvise, AdviseFragment.class.getSimpleName()).commit();
		}
		fgTo = fgAdvise;
		ctvAdvise.setChecked(true);
		lastViewId = R.id.ctv_advise;
	}

	@Override
	public void onClick(View v) {
		allNegative();
		int vid = v.getId();
		FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

		switch (vid) {
			case R.id.ctv_advise:
				ctvAdvise.toggle();
				if (fgAdvise == null) {
					fgAdvise = new AdviseFragment();
				}
				switchFragment(fgTo, fgAdvise, false);
				break;
			case R.id.ctv_song_list:
				ctvSongList.toggle();
				if (fgSong == null) {
					fgSong = new SongListFragment();
				}
				switchFragment(fgTo, fgSong, lastViewId == R.id.ctv_advise);
				break;
			case R.id.ctv_anchor_station:
				ctvAnchorStation.toggle();
				if (fgAnchor == null) {
					fgAnchor = new AnchorStationFragment();
				}
				switchFragment(fgTo, fgAnchor, lastViewId != R.id.ctv_ranking_list);
				break;
			case R.id.ctv_ranking_list:
				ctvRankingList.toggle();
				if (fgRanking == null) {
					fgRanking = new RankingListFragment();
				}
				switchFragment(fgTo, fgSong, true);
				break;
		}

		lastViewId = vid;
//		transaction.commit();
	}

	private void allNegative() {
		ctvAdvise.setChecked(false);
		ctvSongList.setChecked(false);
		ctvAnchorStation.setChecked(false);
		ctvRankingList.setChecked(false);
	}

	public void switchFragment(Fragment from, Fragment to, boolean animFlag) {
		if (from == null || to == null || from == to) {
			return;
		}

		FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

		if (animFlag) {
			transaction.setCustomAnimations(R.anim.push_left_in, R.anim.push_left_out);
		} else {
			transaction.setCustomAnimations(R.anim.push_right_in, R.anim.push_right_out);
		}

		if (!to.isAdded()) {
			// 隐藏当前的fragment，add下一个到Activity中
			transaction.hide(from).add(R.id.frame_container, to).commit();
		} else {
			// 隐藏当前的fragment，显示下一个
			transaction.hide(from).show(to).commit();
		}

		fgTo = to;
	}
}
