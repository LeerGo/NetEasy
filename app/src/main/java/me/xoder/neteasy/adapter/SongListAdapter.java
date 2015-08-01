package me.xoder.neteasy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;

import java.util.Random;

import me.xoder.neteasy.R;
import me.xoder.neteasy.utils.BitmapHelper;
import me.xoder.neteasy.utils.NumberUtil;
import me.xoder.neteasy.view.RoundImageView;

/**
 * Created by alex.lee on 2015-07-31.
 */
public class SongListAdapter extends BaseAdapter {
	private Random random;
	private Context context;
	private int[] imgIds = new int[]{
			R.drawable.sl1, R.drawable.sl2, R.drawable.sl3, R.drawable.sl4, R.drawable.sl5
	};
	private BitmapUtils bitmapUtils;

	public SongListAdapter(Context context) {
		this.context = context;
		random = new Random();
		bitmapUtils = BitmapHelper.getBitmapUtils(context);
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
//			holder.ivStar = (ImageView) convertView.findViewById(R.id.iv_star);
			holder.rivCover = (RoundImageView) convertView.findViewById(R.id.riv_cover);
			holder.tvCount = (TextView) convertView.findViewById(R.id.tv_count);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

//		bitmapUtils.display(holder.ivStar, "drawable://" + imgIds[position % imgIds.length]);
		bitmapUtils.display(holder.rivCover, "drawable://" + imgIds[position % imgIds.length]);
//		holder.rivCover.setImageResource(imgIds[position % imgIds.length]);
		holder.tvCount.setText(NumberUtil.getCount(random.nextInt(200000)));

		return convertView;
	}

	static class ViewHolder {
		TextView tvAuth;
		TextView tvCount;
		TextView tvTitle;
		ImageView ivStar;
		RoundImageView rivCover;
	}
}
