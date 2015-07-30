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
import me.xoder.neteasy.view.RoundImageView;

/**
 * Created by alex.lee on 2015-07-30.
 */
// TODO: 2015-07-30 图片镜像处理
public class CoverFragment extends Fragment {
	private Context context;

	private RoundImageView ivCover;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		context = activity;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_fm_cover, container, false);
		initViews(view);
		return view;
	}

	/**
	 * 初始化界面组件
	 *
	 * @param view 父视图
	 */
	private void initViews(View view) {
		ivCover = (RoundImageView) view.findViewById(R.id.iv_fm_cover);
	}
}