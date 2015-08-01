package me.xoder.neteasy.fragment.discover;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.lidroid.xutils.BitmapUtils;

import me.xoder.neteasy.R;
import me.xoder.neteasy.adapter.SongListAdapter;
import me.xoder.neteasy.utils.BitmapHelper;
import me.xoder.neteasy.view.ScrollGridView;

/**
 * Created by alex.lee on 2015-07-25.
 */
public class SongListFragment extends Fragment {
	private Context context;
	private BitmapUtils mBitmapUtils;


	private ScrollView svRoot;
	private ImageView ivLoading;
	private LinearLayout llContainer;
	private RelativeLayout rlFocusLoading;
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
		ivLoading = (ImageView) view.findViewById(R.id.iv_loading);
		svRoot = (ScrollView) view.findViewById(R.id.fm_songlist_root);
		rlFocusLoading = (RelativeLayout) view.findViewById(R.id.rl_loading);
		llContainer = (LinearLayout) view.findViewById(R.id.ll_sgv_container);
		mScrollGridView = (ScrollGridView) view.findViewById(R.id.sgv_song_list);

//		svRoot.setOnTouchListener(new View.OnTouchListener() {
//			private int lastY = 0;
//
//			@Override
//			public boolean onTouch(View v, MotionEvent event) {
//				if (event.getAction() == MotionEvent.ACTION_UP) {
//					lastY = svRoot.getScrollY();
//					if (lastY == (llContainer.getHeight() - svRoot.getHeight())) {
//						ivLoading.setAnimation(AnimationUtils.loadAnimation(context, R.anim.push_rotate));
//						rlFocusLoading.setVisibility(View.VISIBLE);
//						loadNewData();
//					}
//				}
//
//				return false;
//			}
//		});
		mScrollGridView.setAdapter(new SongListAdapter(context));
	}

	private void loadNewData() {

	}

	private void initArgs() {
		mBitmapUtils = BitmapHelper.getBitmapUtils(context);
	}
}
