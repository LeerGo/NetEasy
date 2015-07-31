package me.xoder.neteasy.fragment.discover;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import me.xoder.neteasy.R;

/**
 * Created by alex.lee on 2015-07-31.
 */
public class SongListAdapter extends BaseAdapter {
	private Context context;
	private Random random;

	public SongListAdapter(Context context) {
		this.context = context;
		random = new Random();
	}

	@Override
	public int getCount() {
		return 10;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {
			holder = new ViewHolder();
			convertView = View.inflate(context, R.layout.item_song_list, null);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		return convertView;
	}

	static class ViewHolder {
		TextView tvAuth;
		TextView tvCount;
		TextView tvTitle;
		ImageView ivStar;
	}
}
