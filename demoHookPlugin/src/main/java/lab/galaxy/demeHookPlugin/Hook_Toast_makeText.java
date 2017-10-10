package lab.galaxy.demeHookPlugin;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import lab.galaxy.activity.Activity_Plugin;
import lab.galaxy.yahfa.HookInfo;
import xiaofei.library.hermeseventbus.HermesEventBus;

/**
 * 717219917@qq.com  2017/8/21 16:33
 */

public class Hook_Toast_makeText {
    public static String className = "android.widget.Toast";
    public static String methodName = "makeText";
    public static String methodSig = "(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;";

    public static Toast hook( Context a, CharSequence b, int c) {
        Log.w("YAHFA", "开始注入toast中a:"+a);
        Log.w("YAHFA", "开始注入toast中b:"+b);
        Intent intent = new Intent(a, Activity_Plugin.class);
        Log.w("YAHFA", "开始注入toast中1intent:"+intent);
//            try{  a.startActivity(intent);}catch (Throwable t){t.printStackTrace();}

        Log.w("YAHFA", "开始注入toast中application:"+HookInfo.application);

        Fragment f = new Fragment( );
        Log.w("YAHFA", "开始注入toast中f:"+f);
//         dialog(a);
//        b="hooked";//更改为hook 之后的内容
        Log.w("YAHFA", "开始注入toast中h了:"+HermesEventBus.getDefault());
//        testt t = new testt();
//        HermesEventBus.getDefault().register(this);
//        HermesEventBus.getDefault().connectApp(a, "io.virtualhook");
//        HermesEventBus.getDefault().post("yahfa 这a是从plugin发送的消息000");
//        HermesEventBus.getDefault().postSticky("yahfa 这是从plugin发送的消息");


//        Log.i("yahfa","hookinfo中wei注册eventbus--"+HermesEventBus.getDefault());
//        HermesEventBus.getDefault().connectApp(HookInfo.application.getApplicationContext(),"io.virtualhook");
//        HermesEventBus.getDefault().post("yahfa 这a是从plugin发送的消息000");
//        HermesEventBus.getDefault().postSticky("yahfa 这a是从plugin发送的消息000");
//        Log.i("yahfa","hookinfo中刚注册eventbus--"+HermesEventBus.getDefault());

        Log.w("YAHFA", "=开始socket");
        if (b.equals("6")){
            Log.w("YAHFA", "if=开始socket--b==6");
            HookInfo.send("6");
        }else {
            Log.w("YAHFA", "else=开始socket--b:---"+b);
            HookInfo.send(b.toString());
        }
        Log.w("YAHFA", "=开始socket000");

        if (b.equals("123456789012345")){
            HookInfo.toast=false;
        }else{
            HookInfo.toast=true;
        }
        return origin(a,b,c);
    }

    public static Toast origin(Context a, CharSequence b, int c) {
        Log.w("YAHFA", "注入toast中完毕,执行后续"+a);
        return null;
    }

    static class  testt {
        public void testt(){
            HermesEventBus.getDefault().register(this);
        }

        @Subscribe(threadMode = ThreadMode.MAIN )
        public void showText(String text) {
            Log.i("yahfa","hook--plugin中eventbus 收到消息："+text);
//        Toast.makeText(HomeActivity.this,"t:"+text,Toast.LENGTH_SHORT).show();
        }


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
