package lab.galaxy.yahfa.internalPlugin;

import android.util.Log;

/**
 * Created by liuruikai756 on 23/08/2017.
 */

public class Hook_ClassWithVirtualMethod_tac {
    public static String className = "lab.galaxy.yahfa.demoApp.ClassWithVirtualMethod";
    public static String methodName = "tac";
    public static String methodSig =
            "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;";

    public static String hook(Object thiz, String a, String b, String c, String d) {
        Log.w("YAHFA", "注入in ClassWithVirtualMethod.tac(): "+a+", "+b+", "+c+", "+d);
        return origin(thiz, a, b, c, d);
    }

    public static String origin(Object thiz, String a, String b, String c, String d) {
        Log.w("YAHFA", "注入222ClassWithVirtualMethod.tac() should not be here");
        return "";
    }
}
