package me.xoder.neteasy.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import me.xoder.neteasy.view.ImgTextView;

/**
 * Created by alex.lee on 2015-07-26.
 */
public class AdvisePagerAdapter extends PagerAdapter {
	private List<ImgTextView> mImgTextViews;

	public AdvisePagerAdapter(List<ImgTextView> imgTextViews) {
		this.mImgTextViews = imgTextViews;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		ImgTextView view = mImgTextViews.get(position % mImgTextViews.size());
		container.addView(view);
		return view;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}

	@Override
	public int getCount() {
		return Integer.MAX_VALUE;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}
}
