package me.xoder.neteasy.scroller;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.animation.Interpolator;
import android.widget.Scroller;

import java.lang.reflect.Field;

/**
 * Created by alex.lee on 2015-07-26.
 */
public class ViewPagerScroller extends Scroller {
	private int mScrollDuration = 2000;             // 滑动速度

	/**
	 * 设置时间
	 *
	 * @param duration 时间
	 */
	public void setScrollDuration(int duration) {
		this.mScrollDuration = duration;
	}

	public ViewPagerScroller(Context context) {
		super(context);
	}

	public ViewPagerScroller(Context context, Interpolator interpolator) {
		super(context, interpolator);
	}

	public ViewPagerScroller(Context context, Interpolator interpolator, boolean flywheel) {
		super(context, interpolator, flywheel);
	}

	@Override
	public void startScroll(int startX, int startY, int dx, int dy, int duration) {
		super.startScroll(startX, startY, dx, dy, mScrollDuration);
	}

	@Override
	public void startScroll(int startX, int startY, int dx, int dy) {
		super.startScroll(startX, startY, dx, dy, mScrollDuration);
	}


	/**
	 * 初始化ViewPagerScroll 通过反射替换时间值
	 *
	 * @param viewPager 需要被控制的 viewPager
	 */
	public void initViewPagerScroll(ViewPager viewPager) {
		try {
			Field mScroller = ViewPager.class.getDeclaredField("mScroller");
			mScroller.setAccessible(true);
			mScroller.set(viewPager, this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
