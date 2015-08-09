package me.xoder.neteasy.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.List;

/**
 * Created by alex.lee on 2015-08-03.
 */
public class AnchorPagerAdapter extends PagerAdapter {
	private List<GridView> mGridViews;

	public AnchorPagerAdapter(List<GridView> views) {
		this.mGridViews = views;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		GridView gridView = mGridViews.get(position);
		container.addView(gridView);
		return gridView;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}

	@Override
	public int getCount() {
		return mGridViews.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}
}
