package lab.galaxy.yahfa.internalPlugin;

import android.util.Log;

/**
 * Created by liuruikai756 on 30/03/2017.
 */

public class Hook_Log_e {
    public static String className = "android.util.Log";
    public static String methodName = "e";
    public static String methodSig = "(Ljava/lang/String;Ljava/lang/String;)I";
    public static int hook(Object thiz,String tag, String msg) {
        Log.w("YAHFA", "这是注入in Log.e(): "+tag+", "+msg);
        return origin(thiz,tag, msg);
    }

    public static int origin(Object thiz,String tag, String msg) {
        Log.w("YAHFA", "这是注入Log.e() should not be here");
        return 1;
    }
}
