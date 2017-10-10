package com.andlp.browser.utils;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;


public class T { //Toast Util
	static Context context;
	private T() {
		throw new UnsupportedOperationException("cannot be instantiated");
	}
	public static boolean isShow = true;//on,off

	//short show
	public static void showShort(Context context, CharSequence message) {
		if (isShow)
			Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
	}

	//
	public static void showShort(Context context, int message) {
		if (isShow)
			Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
	}

	//long show
	public static void showLong(Context context, CharSequence message) {
		if (isShow)
			Toast.makeText(context, message, Toast.LENGTH_LONG).show();
	}


	public static void showLong(Context context, int message) {
		if (isShow)
			Toast.makeText(context, message, Toast.LENGTH_LONG).show();
	}

	//0 short,1 long;default=1
	public static void mormal(Context context, int message, int duration) {
		if (isShow) {
			if (duration == 0) {
				Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(context, message, Toast.LENGTH_LONG).show();
			}
		}

	}


	public static void normal(Context context, CharSequence message, int duration) {
		if (isShow) {
			if (duration == 0) {
				Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(context, message, Toast.LENGTH_LONG).show();
			}

		}

	}

	//short
	public static void show(Context context, CharSequence message) {
		if (isShow)
			Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
	}

	public static final String[] COLORS_RGB = { "#3498db", "#18bc9c",
			"#f39c12", "#e74c3c" };


	public static final int INFO = 0;    //leavel   info
	public static final int SUCCESS = 1; //leavel success
	public static final int WARNING = 2; //leavel warning
	public static final int DANGER = 3;  //leavel danger


	public static void show(Context context, CharSequence text, int st) {
		TextView textView = createTextView(context, text, st);
		Toast toast = new Toast(context);
		toast.setGravity(Gravity.TOP | Gravity.FILL_HORIZONTAL, 0, 0);
		toast.setDuration(Toast.LENGTH_SHORT);
		toast.setView(textView);
		toast.show();
	}


	public static void show(Context context, int resId, int st) {
		String text = context.getResources().getString(resId);
		show(context, text, st);
	}
	public static void info(Context context, CharSequence text) {
		show(context, text, INFO);
	}

	public static void info(Context context, int resId) {
		String text = context.getResources().getString(resId);
		show(context, text, INFO);
	}
	 //show  leavel
	public static void success(Context context, CharSequence text) {
		show(context, text, SUCCESS);
	}


	public static void success(Context context, int resId) {
		String text = context.getResources().getString(resId);
		show(context, text, SUCCESS);
	}

	//show  leavel
	public static void warning(Context context, CharSequence text) {
		show(context, text, WARNING);
	}

	public static void warning(Context context, int resId) {
		String text = context.getResources().getString(resId);
		show(context, text, WARNING);
	}
	public static void danger(Context context, CharSequence text) {
		show(context, text, DANGER);
	}

	public static void danger(Context context, int resId) {
		String text = context.getResources().getString(resId);
		show(context, text, DANGER);
	}
	private static int getHeight(Context context)
	{
		TypedValue tv = new TypedValue();
		if (context.getTheme().resolveAttribute(android.R.attr.actionBarSize,tv, true))
		{
			return TypedValue.complexToDimensionPixelSize(tv.data, context.getResources().getDisplayMetrics());
		} else {
			return 0;
		}
	}

	private static TextView createTextView(Context context, CharSequence text,int st)
	{
		TextView textView = new TextView(context);
		textView.setText(text);
		textView.setBackgroundColor(Color.parseColor(COLORS_RGB[st]));
		textView.setPadding(5, 5, 5, 5);
		textView.setTextColor(Color.WHITE);
		textView.setTextSize(15);
		textView.setGravity(Gravity.CENTER);
		int h = getHeight(context);
		if (h > 0)
		{
			textView.setHeight(h);
		}
		return textView;
	}

}