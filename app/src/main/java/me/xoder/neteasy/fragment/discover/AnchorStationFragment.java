package me.xoder.neteasy.fragment.discover;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;

import java.util.List;

import me.xoder.neteasy.R;

/**
 * Created by alex.lee on 2015-07-25.
 */
public class AnchorStationFragment extends Fragment {
	private Context context;

	private ViewPager mViewPager;
	private LinearLayout mPoints;
	private List<String> stationsName;
	private List<GridView> views;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		context = activity;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_anchor_station, container, false);
//		initViews(view);
		return view;
	}

//	private void initViews(View view) {
//		mViewPager = (ViewPager) view.findViewById(R.id.anchor_viewpager);
//		mPoints = (LinearLayout) view.findViewById(R.id.anchor_viewpager_points);
//
//		initArgs();
//
//		mViewPager.setAdapter(new AnchorPagerAdapter(views));
//		mViewPager.setCurrentItem(0);
//		mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//			private int lastPosition = 0;
//
//			@Override
//			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//			}
//
//			@Override
//			public void onPageSelected(int position) {
//				// 控制底部导航点的显示
//				mPoints.getChildAt(position).setEnabled(true);
//				mPoints.getChildAt(lastPosition).setEnabled(false);
//				lastPosition = position;
//			}
//
//			@Override
//			public void onPageScrollStateChanged(int state) {
//
//			}
//		});
//	}
//
//	private void initArgs() {
//		int dataLen = 20;
//		stationsName = new ArrayList<>(dataLen);
//		for (int i = 0; i < dataLen; i++) {
//			stationsName.add(String.format("%02d%s", i, " 测试"));
//		}
//
//		int len = stationsName.size();
//		LogUtils.v(String.valueOf(len));
//		int viewLength = len / 8 == 0 ? len / 8 : len / 8 + 1;
//		LogUtils.v(String.valueOf(viewLength));
//		views = new ArrayList<>(viewLength);
//
//		for (int i = 0; i < viewLength; i++) {
//			int start = i * 8;
//			int end = i == viewLength - 1 ? dataLen : (i * 8 + 8);
//
//			GridView view = (GridView) View.inflate(context, R.layout.demo_grid, null);
//			view.setAdapter(new AnchorGridAdapter(context, stationsName.subList(start, end)));
//			view.setOnTouchListener(new View.OnTouchListener() {
//				@Override
//				public boolean onTouch(View v, MotionEvent event) {
//					return false;
//				}
//			});
//			views.add(view);
//
//			ImageView point = new ImageView(context);
//			point.setBackgroundResource(R.drawable.viewpager_point);
//			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//			params.rightMargin = DensityUtils.dp2px(context, 10f);
//			params.bottomMargin = DensityUtils.dp2px(context, 10f);
//			point.setLayoutParams(params);
//
//			if (i == 0) {
//				point.setEnabled(true);
//			} else {
//				point.setEnabled(false);
//			}
//
//			mPoints.addView(point);
//
//		}
//	}
}
