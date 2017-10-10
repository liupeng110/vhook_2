package lab.galaxy.demeHookPlugin;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import lab.galaxy.activity.Activity_Plugin;
import lab.galaxy.yahfa.HookInfo;

/**
 * 717219917@qq.com  2017/8/21 16:33
 */

public class Hook_Toast_show {

    public static String className = "android.widget.Toast";
    public static String methodName = "show";
    public static String methodSig = "()V";//参数为空()  返回值为空V

    public static void hook(Object thiz) {
        Log.w("YAHFA", "show开始注入toast中a:"+thiz);
        Log.w("YAHFA", "show开始注入toast中application:"+HookInfo.application);
        if (HookInfo.toast){
            origin(thiz);//注释掉toast不显示  (据需判显示toast不崩)
        }

    }
    public static void origin(Object thiz) {
        Log.w("YAHFA", "show注入toast中完毕,执行后续--"+thiz);
    }

}
