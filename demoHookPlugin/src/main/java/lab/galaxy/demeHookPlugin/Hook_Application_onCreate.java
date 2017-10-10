package lab.galaxy.demeHookPlugin;

import android.app.AlertDialog;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import lab.galaxy.activity.Activity_Plugin;
import lab.galaxy.yahfa.HookInfo;
import xiaofei.library.hermeseventbus.HermesEventBus;

/**
 * 717219917@qq.com  2017/8/21 16:33
 */

public class Hook_Application_onCreate {

    public static String className = "com.andlp.browser.App";
    public static String methodName = "onCreate";
    public static String methodSig = "()V";

    public static void hook( Object thiz) {
        Log.w("YAHFA", "开始注入application中de onCreate:666");
        Log.w("YAHFA", "开始注入application中de onCreate:"+thiz);
//       try{ HermesEventBus.getDefault().connectApp((Application)thiz,"io.virtualhook");}catch (Throwable t){t.printStackTrace();}
          origin(thiz);
    }
    public static void origin(Object thiz) {
        Log.w("YAHFA", "开始注入application中de,执行后续"+thiz);
    }

}
