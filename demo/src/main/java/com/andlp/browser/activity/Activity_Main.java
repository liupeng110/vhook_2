package com.andlp.browser.activity;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.andlp.browser.R;

import java.io.InputStream;


public class Activity_Main extends Activity_Base {
    TextView   tv;
    ImageView  img;
    EditText   search;   //search
    Button sure      ;   //确认搜索
    LinearLayout main;//整体布局
    LinearLayout center; //中间布局
    LinearLayout.LayoutParams LP_WW;



    boolean fullscreen = false;



    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addTop(20);

    }





    private void addTop(int imageID){
        main = new LinearLayout(this);
        main.setOrientation(LinearLayout.VERTICAL);
        setContentView(main);

        LinearLayout layout_top=new LinearLayout(this);
          LP_WW = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        main.setBackgroundColor(Color.WHITE);
        layout_top.setPadding(5, 5, 5, 5);
        layout_top.setLayoutParams(LP_WW);
        layout_top.setOrientation(LinearLayout.VERTICAL);
        layout_top.setGravity(Gravity.CENTER);
        layout_top.setVerticalGravity(Gravity.CENTER_VERTICAL);

        search =new EditText(this);
        search.setPadding(5, 5, 5, 5);
        search.setLayoutParams(LP_WW);
        search.setClickable(true);
        search.setBackgroundResource(R.drawable.line_et_bg);
        search.setId(imageID);

        layout_top.addView(search);
        img = new ImageView(this);
        img.setPadding(5, 5, 5, 5);
        img.setLayoutParams(LP_WW);
        img.setClickable(true);
        img.setId(imageID+1);
        img.setImageResource(R.mipmap.ic_launcher);
        img.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
//                fullscreen(fullscreen);
                TelephonyManager tm = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
                String deviceId = tm.getDeviceId();
                deviceId=search.getText().toString();
                Toast.makeText(Activity_Main.this, deviceId, Toast.LENGTH_SHORT).show();


            }
        });
        layout_top.addView(img);
        main.addView(layout_top);
        addCenter(68,"test");
    }//添加头部view


    private void addCenter(int imageID, String str){
        center=new LinearLayout(this);  //center.setBackgroundColor(Color.argb(0xff, 0x00, 0xff, 0x00));
        center.setPadding(100, 855, 100, 5);
        center.setLayoutParams(LP_WW);
        center.setOrientation(LinearLayout.VERTICAL);
        center.setGravity(Gravity.CENTER);
        center.setVerticalGravity(Gravity.CENTER_VERTICAL);


        sure = new Button(this);
        sure.setText(str);
        sure.setPadding(5, 5, 5, 5);//sure.setLayoutParams(LP_WW);
        sure.setGravity(Gravity.CENTER);
        sure.setClickable(true);
        sure.setId(imageID);
        center.addView(sure);

        tv = new TextView(this);
        tv.setText(str);
        tv.setTextColor(Color.argb(0xff, 0x00, 0x00, 0x00));
        tv.setTextSize(25);
        tv.setGravity(Gravity.CENTER);
        tv.setLayoutParams(LP_WW);
        tv.setId(imageID+1);
        tv.setVisibility(View.INVISIBLE);
        center.addView(tv);


        search =new EditText(this);
        search.setPadding(65, 5, 65, 5);
        search.setLayoutParams(LP_WW);
        search.setClickable(true);
        search.setMaxLines(2);
        search.setId(imageID+2);
        search.setBackgroundResource(R.drawable.line_et_bg);
        center.addView(search);

        main.addView(center);

        sure.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                try {
                    AssetManager asm = getAssets();
                    InputStream is = asm.open("base_bg.png");//name:图片的名称
                    Drawable d = Drawable.createFromStream(is, null);
                    main.setBackground(d);
                }catch (Throwable t){t.printStackTrace();}
            }
        });


//        x.task().postDelayed(new Runnable() {
//            @Override public void run() {
//                addBottom();
//            }
//        },2000);//同步的延时

    }//添加中间的内容


    private void addBottom(){
        center.removeAllViews();
        WebView webView = new WebView(this);
        webView.loadUrl("https://wap.baidu.com/?pu=sz@1321_250");
        webView.setLayoutParams(LP_WW);
        center.addView(webView);

    }//添加底部view



    private void fullscreen(boolean enable) {
        if (enable) { //显示状态栏
            fullscreen=false;
            main.setSystemUiVisibility(View.INVISIBLE);
        } else { //隐藏状态栏
            fullscreen=true;
            main.setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        }
    }//显示隐藏状态栏

}
