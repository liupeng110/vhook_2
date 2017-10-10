package com.andlp.browser.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * 717219917@qq.com  2017/8/11 13:39
 */

public class Activity_Base extends Activity{
    @Override protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        super.onCreate(savedInstanceState);
    }
}
