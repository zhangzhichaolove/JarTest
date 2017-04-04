package com.test.chao.jartest.service;

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
                    Log.e(TAG, "等待接收消息");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
            ToastUtils.showCToast("等待接收消息");
        }
    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        MessageService.this.bindService(new Intent(MessageService.this, GuardService.class),
                mServiceConnection, Context.BIND_IMPORTANT);
        return Service.START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mMessageBind;
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
            Toast.makeText(MessageService.this, "建立连接", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            // 断开连接
            Toast.makeText(MessageService.this, "断开连接", Toast.LENGTH_LONG).show();
            Intent guardIntent = new Intent(MessageService.this, GuardService.class);
            // 发现断开我就从新启动和绑定
            startService(guardIntent);
            MessageService.this.bindService(guardIntent,
                    mServiceConnection, Context.BIND_IMPORTANT);
        }
    }
}