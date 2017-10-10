package lab.galaxy.demeHookPlugin;

import android.util.Log;

/**
 * 717219917@qq.com  2017/8/22 14:56
 */

public class Hook_TelephonyManager_getDeviceId {

    public static String className = "android.telephony.TelephonyManager";
    public static String methodName = "getDeviceId";
    public static String methodSig = "()Ljava/lang/String;";
    public static String hook(Object thiz) {
        Log.i("YAHFA", "注入TelephonyManager getDeviceId hooked");
        return "123456789012345";
    }

    public static String origin(Object thiz) {
        Log.w("YAHFA", "注入注入TelephonyManager中完毕,执行后续");
        return "999999999999999";
    }

}
