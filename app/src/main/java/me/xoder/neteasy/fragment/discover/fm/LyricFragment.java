package me.xoder.neteasy.fragment.discover.fm;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.xoder.neteasy.R;

/**
 * Created by alex.lee on 2015-07-30.
 */
public class LyricFragment extends Fragment {
	private Context context;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		context = activity;
	}
	
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_fm_lyric, container, false);
		initViews(view);
		
		return view;
	}
	
	private void initViews(View view) {

	}
}
