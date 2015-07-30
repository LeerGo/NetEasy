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
public class AdviseFMAdapter extends BaseAdapter {
	private Context context;
	private int[] imgIds = new int[]{R.drawable.item_advise_1, R.drawable.item_advise_2, R.drawable.item_advise_3};
	private String[] titles = new String[]{"私人FM", "每日歌曲推荐", "安雷尔？安蕾丝！！", "无法释怀的循环音乐", "♬一处风雪两白头"};
	private String[] desces = new String[]{"放松下来,享受您的专属", "根据您的兴趣生成,每天推荐惊喜!", "根据你可能新欢的单曲《泡沫？泡馍！》推荐", "根据你收藏的《踏歌长行|仙剑&古剑音乐》推荐", "根据你收藏的《古风合唱~燃！》推荐"};

	public AdviseFMAdapter(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		return 5;
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

		if (position == 0) {
			holder.ivRinght.setVisibility(View.VISIBLE);
			holder.rivCover.setVisibility(View.VISIBLE);
			holder.cvCalendar.setVisibility(View.INVISIBLE);
			holder.rivCover.setImageResource(R.drawable.radio_widget_icn);
		} else if (position == 1) {
			holder.rivCover.setVisibility(View.INVISIBLE);
			holder.ivRinght.setVisibility(View.VISIBLE);
			holder.cvCalendar.setVisibility(View.VISIBLE);
		} else {
			holder.ivRinght.setVisibility(View.INVISIBLE);
			holder.cvCalendar.setVisibility(View.INVISIBLE);
			holder.rivCover.setImageResource(imgIds[position - 2]);
		}

		holder.tvTitle.setText(titles[position]);
		holder.tvDesc.setText(desces[position]);

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
