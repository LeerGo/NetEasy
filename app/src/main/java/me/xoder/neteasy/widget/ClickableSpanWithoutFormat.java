package me.xoder.neteasy.widget;

import android.text.TextPaint;
import android.text.style.ClickableSpan;

public abstract class ClickableSpanWithoutFormat extends ClickableSpan {

	@Override
	public void updateDrawState(TextPaint ds) {
	}
}
