package lab.galaxy.demeHookPlugin;

import android.util.Log;

/**
 * 717219917@qq.com  2017/8/21 16:33
 */

public class Hook_Application_onCreate {

    public static String className = "com.andlp.browser.App";
    public static String methodName = "onCreate";
    public static String methodSig = "()V";

    public static void hook( Object thiz) {
        Log.w("YAHFA", "开始注入application中de onCreate:初始化hook到");
        Log.w("YAHFA", "开始注入application中de onCreate:"+thiz);
        origin(thiz);
    }
    public static void origin(Object thiz) {
        Log.w("YAHFA", "开始注入application中de,执行后续"+thiz);
    }

}
