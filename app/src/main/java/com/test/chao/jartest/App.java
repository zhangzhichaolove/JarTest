package com.test.chao.jartest;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.util.Log;

import com.chao.base.Chao;
import com.chao.exception.ExceptionManagement;
import com.test.chao.jartest.backlayout.BGASwipeBackManager;

import org.xutils.x;

/**
 * Created by Chao on 2017/4/1.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        Chao.Init(this);
        //初始化置入一个不设防的VmPolicy
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {//TODO Android N 会抛出FileUriExposure  URI暴露异常
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }
        Init.getInstance().init(this);
        ExceptionManagement.install(new ExceptionManagement.ExceptionHandler() {

            // handlerException内部建议手动try{  你的异常处理逻辑  }catch(Throwable e){ } ，以防handlerException内部再次抛出异常，导致循环调用handlerException

            @Override
            public void handlerException(final Thread thread, final Throwable throwable) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Log.d("ExceptionManagement", thread + "\n" + throwable.toString());
                            throwable.printStackTrace();
                            //Toast.makeText(App.this, "Exception Happend\n" + thread + "\n" + throwable.toString(), Toast.LENGTH_SHORT).show();
//                        throw new RuntimeException("..."+(i++));
                        } catch (Throwable e) {

                        }
                    }
                });
            }
        });

        // 卸载代码
        ExceptionManagement.uninstall();
        BGASwipeBackManager.getInstance().init(this);
    }
}
