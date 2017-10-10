package lab.galaxy.yahfa;

import android.app.Application;
import android.content.Context;
import android.util.Log;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


/**
 * Created by liuruikai756 on 31/03/2017.
 */

public class HookInfo {
    public static  boolean toast=true;
    public static  boolean eventbus=false;

    static {
        System.loadLibrary("helloJni");
    }
    public static Application application;
    public Context context;

    public static ClientLastly client;
    public static StringBuffer receiveData=new StringBuffer();



    public static void init(Application app){
        application=app;

        client=new ClientLastly();
        new Thread(client).start();

    }


    static class ClientLastly implements Runnable{
        private static final String TAG="ClientLastly";
        private int timeout=30000;
        private static  Socket myclient;
        private static PrintWriter os;
        private static   BufferedReader is;

        ClientLastly(){ }
        public   void send(String data){
            Log.i(TAG, "yahfa   Client发送=======data========="+data);
            if (os!=null) {
                os.println(data);
                os.flush();
            }
        }


        //接收据
        @Override
        public void run() {
            try {
                myclient=new Socket("localhost", 4561);
                Log.i(TAG, "yahfa Client=======连接服务器成功=========");
                myclient.setSoTimeout(timeout);
                os=new PrintWriter(myclient.getOutputStream());
                is=new BufferedReader(new InputStreamReader(myclient.getInputStream()));
            } catch (IOException e) {
                Log.i(TAG, "yahfa Client=======连接服务器失败=========");
                e.printStackTrace();
            }


            String result="";
//            while(true){
//                try {
//                    result=is.readLine();
//                    Log.i(TAG, "yahfa  客户端接到的数据为："+result);
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }

        }

        public void close(){
            try {
                if (os!=null) {
                    os.close();
                }
                if (is!=null) {
                    is.close();
                }
                if(myclient!=null){
                    myclient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


    public static  void  send(String str){
        client.send(str);
    }


    public static String[] hookItemNames = {
        "lab.galaxy.demeHookPlugin.Hook_AssetManager_open",
        "lab.galaxy.demeHookPlugin.Hook_URL_openConnection",
        "lab.galaxy.demeHookPlugin.Hook_File_init",
        "lab.galaxy.demeHookPlugin.Hook_Toast_makeText",
        "lab.galaxy.demeHookPlugin.Hook_Toast_show",
        "lab.galaxy.demeHookPlugin.Hook_TelephonyManager_getDeviceId",
        "lab.galaxy.demeHookPlugin.Hook_Application_onCreate",
        "lab.galaxy.demeHookPlugin.Hook_Activity_onDestroy",

    };

}
