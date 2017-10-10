package com.andlp.browser;

import android.app.Application;
import android.util.Log;

import org.xutils.x;


/**
 * 717219917@qq.com  2017/8/11 14:04
 */
public class App extends Application{

    @Override public void onCreate() {
        super.onCreate();
        x.Ext.init(this);//0
        Log.i("YAHFA", "注入open asset--这是demo中"+this);
    }



    public static int dip2px(float dpValue) {
        final float scale = x.app().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }//dp转成px  参数为dp
    public static int px2dip(float pxValue) {
        final float scale = x.app().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }//px转成dp  参数为px

}
