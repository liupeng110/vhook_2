package lab.galaxy.demeHookPlugin;

import android.util.Log;

import lab.galaxy.yahfa.HookInfo;

/**
 * 717219917@qq.com  2017/8/21 16:33
 */

public class Hook_Activity_onDestroy {
    public static String className = "android.app.Activity";
    public static String methodName = "onDestroy";
    public static String methodSig = "()V";

    public static void hook( Object thiz) {
        Log.w("YAHFA", "开始注入activity中de onDestroy:666");
        Log.w("YAHFA", "开始注入activity中de onDestroy:"+thiz.toString());
//        com.andlp.browser.activity.Activity_Main@fb05c47
         String str = thiz.toString();
              str=str.substring(str.lastIndexOf(".")+1,str.lastIndexOf("@"));
        Log.w("YAHFA", "开始注入activity中de onDestroy:"+str);
          if (str.equals("Activity_Main")){
              HookInfo.send("finish");
              android.os.Process.killProcess(android.os.Process.myPid());
              System.exit(0);
          }


           origin(thiz);
    }
    public static void origin(Object thiz) {
        Log.w("YAHFA", "开始注入application中de,执行后续"+thiz);
    }

}
