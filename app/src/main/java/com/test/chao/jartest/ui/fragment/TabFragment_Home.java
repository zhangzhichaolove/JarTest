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
import com.view.refresh.BGAStickinessRefreshViewHolder;
import com.view.refresh.PullRefreshLayout;

import org.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * 首页
 * Created by Chao on 2017/4/1.
 */

public class TabFragment_Home extends BaseFragment<TabFragmentContract.Presenter> implements TabFragmentContract.View, PullRefreshLayout.BGARefreshLayoutDelegate {

    HomePageAdapter adapter;
    @ViewInject(R.id.recycler)
    RecyclerView recycler;
    @ViewInject(R.id.refresh)
    PullRefreshLayout refresh;

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

        // 粘性下拉刷新头
        BGAStickinessRefreshViewHolder stickinessRefreshViewHolder = new BGAStickinessRefreshViewHolder(
                context, true);
        stickinessRefreshViewHolder.setStickinessColor(R.color.red);
        stickinessRefreshViewHolder
                .setRotateImage(R.mipmap.bga_refresh_stickiness);
        stickinessRefreshViewHolder.setLoadingMoreText("开始加载啦...");
        refresh.setRefreshViewHolder(stickinessRefreshViewHolder);
    }

    @Override
    public void setListener() {
        refresh.setDelegate(this);
        refresh.setPullDownRefreshEnable(true);
        refresh.setIsShowLoadingMoreView(true);
    }

    @Override
    public void showContent(List<JokeListBean> list) {
        adapter.setData(list);
        stop();
    }

    @Override
    public void loadMoreContent(List<JokeListBean> list) {
        adapter.addAll(list);
        stop();
    }

    private void stop() {
        refresh.endRefreshing();
        refresh.endLoadingMore();
        // mRefreshLayout.beginLoadingMore();
    }


    @Override
    public void onBGARefreshLayoutBeginRefreshing(PullRefreshLayout refreshLayout) {
        mPresenter.onRefresh();
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(PullRefreshLayout refreshLayout) {
        mPresenter.loadMore();
        return true;// 返回false数据加载完成不能刷新
    }
}
