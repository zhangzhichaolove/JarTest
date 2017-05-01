package com.test.chao.jartest.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.base.utils.LogUtils;
import com.chao.base.BaseActivity;
import com.chao.camera.CameraHelp;
import com.test.chao.jartest.R;

/**
 * 创建日期：2017/4/2 on 17:38
 * 描述:
 * 作者:张智超 Chao
 */
public class TestActivity extends BaseActivity {

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initTopBar(View layout, TextView finish, TextView title, View... other) {

    }

    @Override
    public void initView() {

    }

//    @Override
//    public void initData() {
//
//    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        CameraHelp.Config config = CameraHelp.getInstance().getConfig();
        config.isCrop = true;
        config.openCamera = true;
        config.openRadio = true;
        config.openMultiselect = true;
        CameraHelp.getInstance().setContext(this).setConfig(config).selectImage();
        CameraHelp.getInstance().setImageSelect(new CameraHelp.ImageSelect() {
            @Override
            public void addImagePath(String... path) {
                for (int i = 0; path != null && i < path.length; i++) {
                    LogUtils.showTagE(path[i]);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int arg0, int arg1, Intent arg2) {
        super.onActivityResult(arg0, arg1, arg2);
        CameraHelp.getInstance().onActivityResult(arg0, arg1, arg2);
    }
}
