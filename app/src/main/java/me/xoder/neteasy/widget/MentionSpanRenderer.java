package me.xoder.neteasy.widget;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import me.xoder.neteasy.R;
import me.xoder.neteasy.utils.DensityUtils;
import me.xoder.neteasy.utils.ToastUtils;

public class MentionSpanRenderer implements AwesomeTextHandler.ViewSpanRenderer, AwesomeTextHandler.ViewSpanClickListener {
	private final static int textSizeInDips = 10;
	private final static int backgroundResource = R.drawable.box_red;
	private final static int textColorResource = R.color.base_color;

	@Override
	public View getView(String text, Context context) {
		TextView view = new TextView(context);
		view.setGravity(Gravity.CENTER_VERTICAL);
		view.setText(text.substring(1));
		view.setTextSize(DensityUtils.sp2px(context, textSizeInDips));
		view.setBackgroundResource(backgroundResource);
		int textColor = context.getResources().getColor(textColorResource);
		view.setTextColor(textColor);
		return view;
	}

	@Override
	public void onClick(String text, Context context) {
		// Do Nothing
		ToastUtils.show(context, text.substring(1));
	}
}
