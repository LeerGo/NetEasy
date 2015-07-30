package me.xoder.neteasy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.xoder.neteasy.R;

/**
 * Created by alex.lee on 2015-07-24.
 */
public class BaseFragment extends Fragment {
	public final static String ARG_COLOR = "object";

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);
		Bundle args = getArguments();
		rootView.setBackgroundColor(args.getInt(ARG_COLOR));
		return rootView;
	}
}
