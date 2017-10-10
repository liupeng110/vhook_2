package io.virtualapp;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import com.lody.virtual.client.NativeEngine;
import com.lody.virtual.client.core.VirtualCore;
import com.lody.virtual.client.stub.VASettings;

import org.xutils.x;

import java.lang.reflect.Method;

import io.virtualapp.delegate.MyAppRequestListener;
import io.virtualapp.delegate.MyComponentDelegate;
import io.virtualapp.delegate.MyPhoneInfoDelegate;
import io.virtualapp.delegate.MyTaskDescriptionDelegate;
import jonathanfinerty.once.Once;
import lab.galaxy.yahfa.HookMain;


/**
 * @author Lody
 */
public class VApp extends Application {

    private static VApp gApp;
    private SharedPreferences mPreferences;

    public static VApp getApp() {
        return gApp;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        mPreferences = base.getSharedPreferences("va", Context.MODE_MULTI_PROCESS);
        VASettings.ENABLE_IO_REDIRECT = true;
        VASettings.ENABLE_INNER_SHORTCUT = false;
        try {
            VirtualCore.get().startup(base);
            NativeEngine.nativeHookExec(Build.VERSION.SDK_INT);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        inject();
    }

    @Override
    public void onCreate() {
        gApp = this;
        super.onCreate();

        VirtualCore virtualCore = VirtualCore.get();
        virtualCore.initialize(new VirtualCore.VirtualInitializer() {

            @Override
            public void onMainProcess() {
                Once.initialise(VApp.this);
            }

            @Override
            public void onVirtualProcess() {
                //listener components
                virtualCore.setComponentDelegate(new MyComponentDelegate());
                //fake phone imei,macAddress,BluetoothAddress
                virtualCore.setPhoneInfoDelegate(new MyPhoneInfoDelegate());
                //fake task description's icon and title
                virtualCore.setTaskDescriptionDelegate(new MyTaskDescriptionDelegate());
            }

            @Override
            public void onServerProcess() {
                virtualCore.setAppRequestListener(new MyAppRequestListener(VApp.this));
                virtualCore.addVisibleOutsidePackage("com.tencent.mobileqq");
                virtualCore.addVisibleOutsidePackage("com.tencent.mobileqqi");
                virtualCore.addVisibleOutsidePackage("com.tencent.minihd.qq");
                virtualCore.addVisibleOutsidePackage("com.tencent.qqlite");
                virtualCore.addVisibleOutsidePackage("com.facebook.katana");
                virtualCore.addVisibleOutsidePackage("com.whatsapp");
                virtualCore.addVisibleOutsidePackage("com.tencent.mm");
                virtualCore.addVisibleOutsidePackage("com.immomo.momo");
            }
        });

        CrashHandler.getInstance().init(this);
        x.Ext.init(this);
        x.Ext.setDebug(true);//


    }


    public static SharedPreferences getPreferences() {
        return getApp().mPreferences;
    }

    private void inject(){

        try {
            Method hook = null;
            Method backup = null;
            Class obj_class = null;
            try {// Context a, CharSequence b, int c
                Class[] pareTyple = {Context.class, CharSequence.class, int.class};
                obj_class = Class.forName("lab.galaxy.yahfa.internalPlugin.Hook_Toast_makeText");
                hook = obj_class.getMethod("hook",pareTyple);
                backup = obj_class.getMethod("origin",pareTyple);

                obj_class = Class.forName("android.widget.Toast");
                HookMain.findAndBackupAndHook(
                        obj_class,"makeText",
                        "(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;",
                        hook,
                        backup
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
//
//        try { //hook
//            Method hook = null;
//            Method backup = null;
//            Class obj_class = null;
//
//            try {
//                Class[] pareTyple = { };
//                obj_class = Class.forName("lab.galaxy.yahfa.internalPlugin.Hook_Toast_show");
//                hook = obj_class.getMethod("hook",pareTyple);
//                backup = obj_class.getMethod("origin",pareTyple);
//
//                obj_class = Class.forName("android.widget.Toast");
//                HookMain.findAndBackupAndHook(
//                        obj_class,"show",
//                        "()V",
//                        hook,
//                        backup
//                );
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }

        try { //hook
            Method hook = null;
            Method backup = null;
            Class obj_class = null;
            try {
                Class[] pareTyple = {Object.class, String.class, String.class, String.class, String.class};
                obj_class = Class.forName("lab.galaxy.yahfa.internalPlugin.Hook_ClassWithVirtualMethod_tac");
                hook = obj_class.getMethod("hook",pareTyple);
                backup = obj_class.getMethod("origin",pareTyple);

                obj_class = Class.forName("io.virtualapp.splash.ClassWithVirtualMethod");
                HookMain.findAndBackupAndHook(
                        obj_class,"tac",
                        "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;",
                        hook,
                        backup
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }



        try { //hook
            Method hook = null;
            Method backup = null;
            Class obj_class = null;
            try {
                Class[] pareTyple = {String.class, String.class};
                obj_class = Class.forName("lab.galaxy.yahfa.internalPlugin.Hook_Log_e");
                hook = obj_class.getMethod("hook",pareTyple);
                backup = obj_class.getMethod("origin",pareTyple);

                obj_class = Class.forName("android.util.Log");
                HookMain.findAndBackupAndHook(
                        obj_class,"e",
                        "(Ljava/lang/String;Ljava/lang/String;)I",
                        hook,
                        backup
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }




    }

}
