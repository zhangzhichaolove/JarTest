package com.test.chao.jartest.service;

import android.app.Notification;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.base.utils.ToastUtils;
import com.chao.system.LogUtils;
import com.test.chao.jartest.ProcessConnection;

public class MessageService extends Service {

    private static final String TAG = "MessageService";

    private MessageServiceConnection mServiceConnection;
    private MessageBind mMessageBind;

    @Override
    public void onCreate() {
        super.onCreate();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    LogUtils.showTagE(TAG, "等待接收消息");
                    handler.sendEmptyMessage(0);
                }
            }
        }).start();


        if (mServiceConnection == null) {
            mServiceConnection = new MessageServiceConnection();
        }

        if (mMessageBind == null) {
            mMessageBind = new MessageBind();
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //ToastUtils.showCToast("正在后台运行!");
            Toast.makeText(MessageService.this, "正在后台运行!", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        bindService(new Intent(MessageService.this, GuardService.class),
                mServiceConnection, Context.BIND_IMPORTANT);
        startForeground(0, new Notification());
        return Service.START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mMessageBind;
    }

    /**
     * 在内存紧张的时候，系统回收内存时，会回调OnTrimMemory， 重写onTrimMemory当系统清理内存时从新启动Service
     */
    @Override
    public void onTrimMemory(int level) {
        /*
         * 启动service
         */
        LogUtils.showTagE("收到内存回收请求，请求等级：" + level);
    }

    private class MessageBind extends ProcessConnection.Stub {

        @Override
        public void processConnected() throws RemoteException {
            Log.e("TAG", "processConnected");
        }
    }

    private class MessageServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // 建立连接
            ToastUtils.showCToast("建立连接");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            // 断开连接
            ToastUtils.showCToast("断开连接");
            Intent guardIntent = new Intent(MessageService.this, GuardService.class);
            // 发现断开我就从新启动和绑定
            bindService(guardIntent,
                    mServiceConnection, Context.BIND_IMPORTANT);
            startService(guardIntent);
        }
    }
}