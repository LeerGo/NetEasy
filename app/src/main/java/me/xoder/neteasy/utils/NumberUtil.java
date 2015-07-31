package me.xoder.neteasy.utils;

/**
 * Created by alex.lee on 2015-07-31.
 */
public class NumberUtil {
	public static String getCount(int count) {
		if (count < 100000) {
			return count + "";
		} else {
			return count / 10000 + "万";
		}
	}
}
