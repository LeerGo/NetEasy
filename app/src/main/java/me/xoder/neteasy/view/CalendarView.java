package me.xoder.neteasy.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import me.xoder.neteasy.R;

/**
 * Created by alex.lee on 2015-07-27.
 */
public class CalendarView extends LinearLayout {
	private TextView tvDate;
	private TextView tvWeek;
	private LayoutInflater inflater;
	private LinearLayout mLinearLayout;

	private Date date;
	private SimpleDateFormat dateFm;

	public CalendarView(Context context) {
		super(context, null);
		initViews(context);
	}
	
	public CalendarView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initViews(context);
	}
	
	private void initViews(Context context) {
		inflater = LayoutInflater.from(context);
		mLinearLayout = (LinearLayout) inflater.inflate(R.layout.calendar_view, this);
		tvDate = (TextView) mLinearLayout.findViewById(R.id.tv_date);
		tvWeek = (TextView) mLinearLayout.findViewById(R.id.tv_week);

		tvDate.setText(getDate());
		tvWeek.setText(getWeek());
	}

	private String getDate() {
		date = new Date();
		dateFm = new SimpleDateFormat("dd");
		return dateFm.format(date);
	}

	private String getWeek() {
		date = new Date();
		dateFm = new SimpleDateFormat("EEEE");
		return dateFm.format(date);
	}
}
