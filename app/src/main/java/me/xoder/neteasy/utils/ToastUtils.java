package me.xoder.neteasy.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by alex.lee on 2015-07-24.
 */
public class ToastUtils {
	public static void show(Context context, String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}
}
