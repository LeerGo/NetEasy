package me.xoder.neteasy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import me.xoder.neteasy.R;

/**
 * Created by alex.lee on 2015-07-26.
 */
public class ImgTextView extends FrameLayout {
	private String tips;
	private String type;
	private Drawable source;

	private TextView mTextView;
	private ImageView mImageView;
	private FrameLayout mFrameLayout;
	private LinearLayout mLinearLayout;

	private LayoutInflater inflater;

	public ImgTextView(Context context) {
		super(context, null);
		initViews(context);
	}

	public ImgTextView(Context context, AttributeSet attrs) {
		super(context, attrs, 0);
		TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.ImgTextView);
		tips = array.getString(R.styleable.ImgTextView_tips);
		type = array.getString(R.styleable.ImgTextView_back);
		source = array.getDrawable(R.styleable.ImgTextView_src);
		array.recycle();

		initViews(context);
	}

	private void initViews(Context context) {
		inflater = LayoutInflater.from(context);
		mFrameLayout = (FrameLayout) inflater.inflate(R.layout.img_text_view, this);
		mTextView = (TextView) mFrameLayout.findViewById(R.id.itv_tv);
		mImageView = (ImageView) mFrameLayout.findViewById(R.id.itv_iv);
		mLinearLayout = (LinearLayout) mFrameLayout.findViewById(R.id.itv_ll);

		mTextView.setText(tips);
		mImageView.setImageDrawable(source);

		changeBack(type);
	}

	private void changeBack(String type) {
		if (type == null) {
			mLinearLayout.setBackgroundResource(R.drawable.tip_red);
		} else {
			if (type.equals("red")) {
				mLinearLayout.setBackgroundResource(R.drawable.tip_red);
			} else if (type.equals("blue")) {
				mLinearLayout.setBackgroundResource(R.drawable.tip_blue);
			}
		}
	}

	public void setTips(String tips) {
		mTextView.setText(tips);
	}

	public void setType(String type) {
		changeBack(type);
	}

	public void setSource(int resId) {
		mImageView.setImageResource(resId);
	}

	public void setSource(Drawable drawable) {
		mImageView.setImageDrawable(drawable);
	}
}