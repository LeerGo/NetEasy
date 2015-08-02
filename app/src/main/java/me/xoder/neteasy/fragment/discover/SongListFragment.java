package me.xoder.neteasy.fragment.discover;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.util.LogUtils;

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

	private SongListAdapter mAdapter;

	private boolean isLoading = false;

	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (msg.what == 0x123) {
				LogUtils.v("lastY --> 加载更多数据");
				mAdapter.refresh();
				rlFocusLoading.setVisibility(View.INVISIBLE);
				isLoading = false;
			}
		}
	};

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

		svRoot.setOnTouchListener(new View.OnTouchListener() {
			private int lastY = 0;

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if ((event.getAction() == MotionEvent.ACTION_UP) && !isLoading) {
					lastY = svRoot.getScrollY();

					LogUtils.v("lastY = " + lastY + " -- llContainer.getHeight() - svRoot.getHeight() = " + (llContainer.getHeight() - svRoot.getHeight()));

					int flag = llContainer.getHeight() - svRoot.getHeight();
					if (lastY > flag || lastY == flag) {
						ivLoading.setAnimation(AnimationUtils.loadAnimation(context, R.anim.push_rotate));
						rlFocusLoading.setVisibility(View.VISIBLE);
						loadNewData();
						isLoading = true;
					}
				}

				return false;
			}
		});
		mScrollGridView.setAdapter(mAdapter);
	}

	private void loadNewData() {
		mHandler.sendEmptyMessageDelayed(0x123, 2000);
	}

	private void initArgs() {
		mAdapter = new SongListAdapter(context);
		mBitmapUtils = BitmapHelper.getBitmapUtils(context);
	}
}
