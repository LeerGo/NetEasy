package me.xoder.neteasy.fragment.discover;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import me.xoder.neteasy.R;
import me.xoder.neteasy.activity.PersonalFMActivity;
import me.xoder.neteasy.adapter.AdviseFMAdapter;
import me.xoder.neteasy.adapter.AdviseGridAdapter;
import me.xoder.neteasy.adapter.AdviseNewestAdapter;
import me.xoder.neteasy.adapter.AdvisePagerAdapter;
import me.xoder.neteasy.scroller.ViewPagerScroller;
import me.xoder.neteasy.utils.DensityUtils;
import me.xoder.neteasy.view.ImgTextView;
import me.xoder.neteasy.view.ScrollGridView;
import me.xoder.neteasy.view.ScrollListView;

/**
 * Created by alex.lee on 2015-07-25.
 */
public class AdviseFragment extends Fragment {
	private Context context;

	private ViewPager mViewPager;
	private LinearLayout mPoints;

	private ScrollListView mNewestListView;
	private ScrollListView mPersonalListView;
	private ScrollGridView mScrollGridView;

	private int[] imgIds;
	private String[] tips;
	private String[] types;
	private int lastPosition;
	private boolean isRunning;
	private List<ImgTextView> mImgTextViews;

	private static final int delay = 3000;

	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (msg.what == 0) {
				mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1, true);
				if (isRunning) {
					mHandler.sendEmptyMessageDelayed(0, delay);
				}
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
		View view = inflater.inflate(R.layout.fragment_advise, container, false);
		initViews(view);

		return view;
	}

	/**
	 * 初始化界面
	 *
	 * @param view 父视图
	 */
	private void initViews(View view) {
		mScrollGridView = (ScrollGridView) view.findViewById(R.id.my_grid);
		mPersonalListView = (ScrollListView) view.findViewById(R.id.lv_advise);
		mNewestListView = (ScrollListView) view.findViewById(R.id.lv_newest_music);

		mViewPager = (ViewPager) view.findViewById(R.id.banner_viewpager);
		mPoints = (LinearLayout) view.findViewById(R.id.banner_viewpager_points);

		initArgs();

		mViewPager.setAdapter(new AdvisePagerAdapter(mImgTextViews));
		mViewPager.setCurrentItem(Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2 % mImgTextViews.size(), true);
		// 重写触摸事件 完成点击时轮播暂停的效果
		mViewPager.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
					case MotionEvent.ACTION_DOWN:
						mHandler.removeMessages(0);
						break;
					case MotionEvent.ACTION_UP:
						mHandler.sendEmptyMessageDelayed(0, delay);
						break;
				}
				return false;
			}
		});
		mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageSelected(int position) {
				// 控制底部导航点的显示
				position %= imgIds.length;
				mPoints.getChildAt(position).setEnabled(true);
				mPoints.getChildAt(lastPosition).setEnabled(false);
				lastPosition = position;
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});
		// 设置动画
//		mViewPager.setPageTransformer(true, new DepthPageTransformer());
		ViewPagerScroller scroller = new ViewPagerScroller(context);
		// 控制自动播放时时间
		scroller.setScrollDuration(delay);
		scroller.initViewPagerScroll(mViewPager);
		mHandler.sendEmptyMessageDelayed(0, delay);

		mScrollGridView.setMoveFlag(false);
		mScrollGridView.setAdapter(new AdviseGridAdapter(context));
		mPersonalListView.setAdapter(new AdviseFMAdapter(context));
		mNewestListView.setAdapter(new AdviseNewestAdapter(context));

		mPersonalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				switch (position) {
					case 0:
						startActivity(new Intent(context, PersonalFMActivity.class));
						break;
					default:
						break;
				}
			}
		});
	}

	/**
	 * 初始化参数
	 */
	private void initArgs() {
		isRunning = true;
		mImgTextViews = new ArrayList<>();
		imgIds = new int[]{R.drawable.banner_pager_1, R.drawable.banner_pager_2, R.drawable.banner_pager_3, R.drawable.banner_pager_4, R.drawable.banner_pager_5};
		types = new String[]{"blue", "blue", "red", "red", "red"};
		tips = new String[]{"音乐大战", "我的最爱", "所长别开枪", "OWN CITY", "Mine WORLD!"};

		for (int i = 0; i < imgIds.length; i++) {
			ImgTextView imageTextView = new ImgTextView(context);
			imageTextView.setSource(imgIds[i]);
			imageTextView.setTips(tips[i]);
			imageTextView.setType(types[i]);
			mImgTextViews.add(imageTextView);

			ImageView point = new ImageView(context);
			point.setBackgroundResource(R.drawable.viewpager_point);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
			params.rightMargin = DensityUtils.dp2px(context, 10f);
			params.bottomMargin = DensityUtils.dp2px(context, 10f);
			point.setLayoutParams(params);

			if (i == 0) {
				point.setEnabled(true);
			} else {
				point.setEnabled(false);
			}

			mPoints.addView(point);
		}
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		isRunning = false;
	}
}
