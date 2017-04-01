package com.test.chao.jartest.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chao.base.BaseFragment;
import com.test.chao.jartest.R;
import com.test.chao.jartest.adapter.HomePageAdapter;
import com.test.chao.jartest.bean.JokeListBean;
import com.test.chao.jartest.contract.TabFragmentContract;
import com.test.chao.jartest.contract.impl.TabFragmentPresenter;

import org.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * 首页
 * Created by Chao on 2017/4/1.
 */

public class TabFragment_Home extends BaseFragment implements TabFragmentContract.View {

    TabFragmentContract.Presenter mPresenter;
    HomePageAdapter adapter;
    @ViewInject(R.id.recycler)
    RecyclerView recycler;

    public static TabFragment_Home newInstance() {
        Bundle args = new Bundle();
        TabFragment_Home fragment = new TabFragment_Home();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initTopBar(View layout, TextView left, TextView title, View... other) {

    }


    @Override
    public void initView(View view) {
        new TabFragmentPresenter(this);
        mPresenter.start();
    }

    @Override
    public void initData() {
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(manager);
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.addItemDecoration(new DividerItemDecoration(context, LinearLayout.VERTICAL));
        adapter = new HomePageAdapter(context, null, R.layout.item_homepage);
        recycler.setAdapter(adapter);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void showContent(List<JokeListBean> list) {
        adapter.setData(list);
    }

    @Override
    public void setPresenter(TabFragmentContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
