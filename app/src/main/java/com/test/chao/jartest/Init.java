package com.test.chao.jartest;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;

import com.chao.chao.BaseConfig;
import com.chao.chao.Cpublic;

public class Init {

    public static Init INSTANCE;

    public static Init getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Init();
        }
        return INSTANCE;
    }

    public void init(Application app) {

        Cpublic.setDeBug(true);// 开启DeBug模式
        Cpublic.setPrintln(true);// 是否开启打印输出
        Cpublic.setToastdefault(true);// 是否使用系统Toast
        Cpublic.setToastInitTextColor(Color.WHITE);// 全局Toast文字颜色
        Cpublic.setToastInitBackground(R.drawable.bg_rectangle_10dp);//全局Toast背景
        Cpublic.setAdapterUpdate(true);// 开启全局ListView无数据背景
        Cpublic.setAdapterBackgroud(InitView(app));// 设置全局ListView无数据背景

        Cpublic.setHttpCaChe(true);// 是否开启网络缓存
        Cpublic.setSilder(false);// 开启侧滑关闭
        //Cpublic.setBackLayout(true);// 开启侧滑关闭
        Cpublic.setSendException(false);// 是否开启异常捕捉
        Cpublic.setAppListener(true);// 是否开启App状态监听
        Cpublic.setBackgroudColor(true);// 开启换肤功能
        Cpublic.setTransparent(true);// 是否开启沉侵式状态栏(伪沉侵)
        Cpublic.setTruetransparent(true);// 是否开启沉侵式状态栏二(完全沉侵)
        Cpublic.setTitleColor("#FFC0CB");// 默认主题颜色

        BaseConfig.setBaseTitle("base_activity", "content", "toolbar", "layout", "finish", "title", "other");
    }

    //这里初始化一个ListView无数据时候的背景，当ListView内部无数据时，会自动显示此背景，如果上面没有开启此功能，可以不用设置。
    private View InitView(Context context) {
        View view = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(
                    R.layout.list_view_background, null);
        }
        return view;
    }

}