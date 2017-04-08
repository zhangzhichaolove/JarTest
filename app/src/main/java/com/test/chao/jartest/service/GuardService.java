package com.test.chao.jartest.service;

import android.app.Notification;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.test.chao.jartest.ProcessConnection;

/**
 * 创建日期：2017/4/4 on 13:36
 * 描述:
 * 作者:张智超 Chao
 */
public class GuardService extends Service {
    private MessageServiceConnection mServiceConnection;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG", "onCreate");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("TAG", "onBind");
        return new MessageBind();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mServiceConnection = new MessageServiceConnection();
        bindService(new Intent(GuardService.this, MessageService.class),
                mServiceConnection, Context.BIND_IMPORTANT);
        startForeground(0, new Notification());//设置为前台进程
        return Service.START_STICKY;
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
            Toast.makeText(GuardService.this, "建立连接", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            // 断开连接
            Toast.makeText(GuardService.this, "断开连接", Toast.LENGTH_LONG).show();
            Intent guardIntent = new Intent(GuardService.this, MessageService.class);
            // 发现断开我就从新启动和绑定
            bindService(guardIntent,
                    mServiceConnection, Context.BIND_IMPORTANT);
            startService(guardIntent);
        }
    }

}
