package me.xoder.neteasy.fragment.discover;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lidroid.xutils.BitmapUtils;

import me.xoder.neteasy.R;
import me.xoder.neteasy.utils.BitmapHelper;
import me.xoder.neteasy.view.ScrollGridView;

/**
 * Created by alex.lee on 2015-07-25.
 */
public class SongListFragment extends Fragment {
	private Context context;
	private BitmapUtils mBitmapUtils;

	private ScrollGridView mScrollGridView;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		context = activity;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_song_list, container, false);
		initViews(view);
		return view;
	}

	private void initViews(View view) {
		initArgs();

		mScrollGridView = (ScrollGridView) view.findViewById(R.id.sgv_song_list);
	}

	private void initArgs() {
		mBitmapUtils = BitmapHelper.getBitmapUtils(context);
	}
}
