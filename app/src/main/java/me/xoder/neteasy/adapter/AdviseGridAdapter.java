package me.xoder.neteasy.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Random;

import me.xoder.neteasy.R;
import me.xoder.neteasy.view.RoundImageView;
import me.xoder.neteasy.widget.AwesomeTextHandler;
import me.xoder.neteasy.widget.MentionSpanRenderer;

/**
 * Created by alex.lee on 2015-07-26.
 */
public class AdviseGridAdapter extends BaseAdapter {
	private Random random;
	private Context context;
	private int[] ids = new int[]{
			R.drawable.hot_advise_5, R.drawable.hot_advise_5, R.drawable.hot_advise_5,
			R.drawable.hot_advise_6, R.drawable.hot_advise_6, R.drawable.hot_advise_6
	};
	private static final String MENTION_PATTERN = "(@[\\p{L}0-9-_]+)";

	public AdviseGridAdapter(Context context) {
		this.context = context;
		random = new Random();
	}

	@Override
	public int getCount() {
		return 6;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {
			holder = new ViewHolder();
			convertView = View.inflate(context, R.layout.item_grid, null);

			holder.rivCover = (RoundImageView) convertView.findViewById(R.id.riv_cover);
			holder.tvCount = (TextView) convertView.findViewById(R.id.tv_count);
			holder.tvDesc = (TextView) convertView.findViewById(R.id.tv_desc);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.rivCover.setImageResource(ids[position]);
		holder.tvCount.setText(getCount(random.nextInt(250000)));
		if (position == 3 || position == 5) {
			holder.tvDesc.setText("@电台节目 测试数据测试数据测试数据");
			AwesomeTextHandler awesomeEditTextHandler = new AwesomeTextHandler();
			awesomeEditTextHandler.addViewSpanRenderer(MENTION_PATTERN, new MentionSpanRenderer()).setView(holder.tvDesc);
		} else {
			holder.tvDesc.setText("测试数据测试数据测试数据");
		}

		return convertView;
	}

	static class ViewHolder {
		RoundImageView rivCover;
		TextView tvCount;
		TextView tvDesc;
	}

	private String getCount(int count) {
		if (count < 100000) {
			return count + "";
		} else {
			return count / 10000 + "万";
		}
	}
}
