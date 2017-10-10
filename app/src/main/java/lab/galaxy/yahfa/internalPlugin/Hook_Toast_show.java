package lab.galaxy.yahfa.internalPlugin;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;


/**
 * 717219917@qq.com  2017/8/21 16:33
 */

public class Hook_Toast_show {

    public static String className = "android.widget.Toast";
    public static String methodName = "show";
    public static String methodSig = "()V";//参数为空()  返回值为空V

    public static void hook(Object thiz) {
        Log.w("YAHFA", "show开始注入toast中a:"+thiz);
//        Log.w("YAHFA", "show开始注入toast中MainApp:"+MainApp.hoo);
//        if (MainApp.hoo){
//            origin(thiz);//注释掉toast不显示  (据需判显示toast不崩)
//        }
        origin(thiz);

    }
    public static void origin(Object thiz) {
        Log.w("YAHFA", "show注入toast中完毕,执行后续--"+thiz);
    }


    public static void dialog(Context context){
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case AlertDialog.BUTTON_POSITIVE:// "确认"
                        Log.i("yahfa","dialog  点击确认");
                        break;
                    case AlertDialog.BUTTON_NEGATIVE:// "取消"
                        Log.i("yahfa","dialog  点击取消");
                        break;
                    default:
                        break;
                }
            }
        };
        AlertDialog dialog = new AlertDialog.Builder(context).create();
        dialog.setTitle("system prompt"); // 设置对话框标题
        dialog.setMessage("Excuse me are you sure you want to exit?"); // 设置对话框消息
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Comfirm", listener);// 添加选择按钮并注册监听
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancle",  listener);
        Log.i("yahfa","dialog  show了");
        dialog.show();// 显示对话框

    }



}
