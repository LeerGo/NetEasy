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

import java.util.ArrayList;
import java.util.List;

import me.xoder.neteasy.R;
import me.xoder.neteasy.adapter.AnchorGridAdapter;
import me.xoder.neteasy.adapter.AnchorPagerAdapter;

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
		initViews(view);
		return view;
	}

	private void initViews(View view) {
		initArgs();

		mViewPager = (ViewPager) view.findViewById(R.id.banner_viewpager);
		mPoints = (LinearLayout) view.findViewById(R.id.banner_viewpager_points);

		mViewPager.setAdapter(new AnchorPagerAdapter(views));
		mViewPager.setCurrentItem(0);
		mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			private int lastPosition = 0;
			
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
				
			}
			
			@Override
			public void onPageSelected(int position) {
				// 控制底部导航点的显示
				mPoints.getChildAt(position).setEnabled(true);
				mPoints.getChildAt(lastPosition).setEnabled(false);
				lastPosition = position;
			}
			
			@Override
			public void onPageScrollStateChanged(int state) {
				
			}
		});
	}
	
	private void initArgs() {
		stationsName = new ArrayList<>(20);
		for (int i = 0; i < stationsName.size(); i++) {
			stationsName.add(String.format("%02d%s", i, " 测试"));
		}

		int len = stationsName.size();
		views = new ArrayList<>(len / 8 == 0 ? len / 8 : len / 8 + 1);
		for (int i = 0; i < views.size(); i++) {
			GridView view = (GridView) View.inflate(context, R.layout.demo_grid, null);
			view.setAdapter(new AnchorGridAdapter(context, stationsName.subList(i * 8, i * 8 + 7)));
			views.add(view);
		}
	}
}
