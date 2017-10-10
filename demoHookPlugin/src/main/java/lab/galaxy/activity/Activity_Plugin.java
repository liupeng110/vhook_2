package lab.galaxy.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * 717219917@qq.com  2017/8/30 14:11
 */

public class Activity_Plugin extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);
        textView.setText("66666666");
        textView.setTextSize(35);
        textView.setTextColor(45523);
        setContentView(textView);

    }
}
