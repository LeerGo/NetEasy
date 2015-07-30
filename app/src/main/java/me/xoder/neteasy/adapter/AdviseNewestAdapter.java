package me.xoder.neteasy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import me.xoder.neteasy.R;
import me.xoder.neteasy.view.CalendarView;
import me.xoder.neteasy.view.RoundImageView;

/**
 * Created by alex.lee on 2015-07-27.
 */
public class AdviseNewestAdapter extends BaseAdapter {
	private Context context;
	private int[] imgIds = new int[]{R.drawable.item_newest_1, R.drawable.item_newest_2, R.drawable.item_newest_3};
	private String[] titles = new String[]{"新歌速递", "新碟上架", "MV频道",};

	public AdviseNewestAdapter(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		return 3;
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
			convertView = View.inflate(context, R.layout.item_list, null);

			holder.rivCover = (RoundImageView) convertView.findViewById(R.id.iv_cover);
			holder.ivRinght = (ImageView) convertView.findViewById(R.id.iv_right_arr);
			holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
			holder.tvDesc = (TextView) convertView.findViewById(R.id.tv_desc);
			holder.cvCalendar = (CalendarView) convertView.findViewById(R.id.cv_calendar);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.tvTitle.setText(titles[position]);
		holder.rivCover.setImageResource(imgIds[position]);
		holder.cvCalendar.setVisibility(View.INVISIBLE);
		holder.tvDesc.setVisibility(View.GONE);
		holder.ivRinght.setVisibility(View.VISIBLE);

		return convertView;
	}

	static class ViewHolder {
		RoundImageView rivCover;
		ImageView ivRinght;
		TextView tvTitle;
		TextView tvDesc;
		CalendarView cvCalendar;
	}
}
