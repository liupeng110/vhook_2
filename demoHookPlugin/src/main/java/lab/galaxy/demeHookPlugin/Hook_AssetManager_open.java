package lab.galaxy.demeHookPlugin;

import android.util.Log;

import java.io.InputStream;

import lab.galaxy.yahfa.HookInfo;


public class Hook_AssetManager_open {
    public static String className = "android.content.res.AssetManager";
    public static String methodName = "open";
    public static String methodSig = "(Ljava/lang/String;)Ljava/io/InputStream;";//参数为string 包名java.io.inputstream
    public static InputStream hook(Object thiz, String fileName) {
        Log.w("YAHFA", "注入open asset "+fileName);
       try{ Log.w("YAHFA", "注入open asset "+HookInfo.application);}catch (Throwable t){t.printStackTrace();}

        return null;
//        return origin(thiz, fileName);
    }

    public static InputStream origin(Object thiz, String msg) {
        Log.w("YAHFA", "注入should not be here");
        return null;
    }
}
