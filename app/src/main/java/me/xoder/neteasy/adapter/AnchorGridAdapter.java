package me.xoder.neteasy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import me.xoder.neteasy.R;

/**
 * Created by alex.lee on 2015-08-03.
 */
public class AnchorGridAdapter extends BaseAdapter {
	private Context context;
	private List<String> values;

	public AnchorGridAdapter(Context context, List<String> values) {
		this.values = values;
		this.context = context;
	}

	@Override
	public int getCount() {
		return values.size();
	}

	@Override
	public Object getItem(int position) {
		return values.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holer;

		if (convertView == null) {
			holer = new ViewHolder();
			convertView = View.inflate(context, R.layout.item_grid_anchor, null);
			holer.tvName = (TextView) convertView.findViewById(R.id.tv_anchor_name);
			convertView.setTag(holer);
		} else {
			holer = (ViewHolder) convertView.getTag();
		}

		holer.tvName.setText(values.get(position));

		return convertView;
	}

	static class ViewHolder {
		private TextView tvName;
	}
}
