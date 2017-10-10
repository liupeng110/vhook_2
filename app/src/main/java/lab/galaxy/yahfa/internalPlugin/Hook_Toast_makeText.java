package lab.galaxy.yahfa.internalPlugin;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;


/**
 * 717219917@qq.com  2017/8/21 16:33
 */

public class Hook_Toast_makeText {
    public static String className = "android.widget.Toast";
    public static String methodName = "makeText";
    public static String methodSig = "(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;";
//    public static  AlertDialog dialog;
    public static Toast hook( Context a, CharSequence b, int c) {
        Log.w("YAHFA", "开始注入toast中a:"+a);
        Log.w("YAHFA", "开始注入toast中b:"+b);
          b="hook";
//        Log.w("YAHFA", "开始注入MainApp.hoo:"+MainApp.hoo);
//        if (MainApp.hoo){
//            MainApp.hoo=false;
////            dialog(a);
//        }
//        Log.w("YAHFA", "开始注入=开始socket000"+MainApp.hoo);
        return origin(a,b,c);
    }

    public static Toast origin(Context a, CharSequence b, int c) {
        Log.w("YAHFA", "注入toast中完毕,执行后续"+a);
        return null;
    }


//    public static void dialog(Context context){
////        DialogInterface.OnClickListener listener =  new DialogInterface.OnClickListener() {
////            public void onClick(DialogInterface dialog, int which) {
////                switch (which) {
////                    case AlertDialog.BUTTON_POSITIVE:// "确认"
////                        Log.i("yahfa","dialog  点击确认");
////                        break;
////                    case AlertDialog.BUTTON_NEGATIVE:// "取消"
////                        Log.i("yahfa","dialog  点击取消");
////                        break;
////                    default:
////                        break;
////                }
////            }
////        };
//        try {
//            AlertDialog dialog = new AlertDialog.Builder(context).create();
//            dialog.setTitle("system prompt"); // 设置对话框标题
//            dialog.setMessage("Excuse me are you sure you want to exit?"); // 设置对话框消息
////        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Comfirm", listener);// 添加选择按钮并注册监听
////        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancle",  listener);
//            Log.i("yahfa", "注入dialog  show了");
//            dialog.show();// 显示对话框
//        }catch (Throwable t){t.printStackTrace();}
//    }

}
