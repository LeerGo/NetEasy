package me.xoder.neteasy.adapter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import me.xoder.neteasy.fragment.BaseFragment;
import me.xoder.neteasy.fragment.discover.DiscoverFragment;

public class TabContentPagerAdapter extends FragmentPagerAdapter {

	public TabContentPagerAdapter(FragmentManager fragmentManager) {
		super(fragmentManager);
	}

	@Override
	public Fragment getItem(int i) {
		Fragment fragment = null;
		Bundle args = new Bundle();

		switch (i) {
			case 0:
				fragment = new DiscoverFragment();
				break;
			case 1:
				fragment = new BaseFragment();
				args.putInt(BaseFragment.ARG_COLOR, Color.WHITE);
				fragment.setArguments(args);
				break;
			case 2:
				fragment = new BaseFragment();
				args.putInt(BaseFragment.ARG_COLOR, Color.WHITE);
				fragment.setArguments(args);
				break;
		}


		return fragment;
	}

	@Override
	public int getCount() {
		return 3;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return "Object -- " + (++position);
	}
}