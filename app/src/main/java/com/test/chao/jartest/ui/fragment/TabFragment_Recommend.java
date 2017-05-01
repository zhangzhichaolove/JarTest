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
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.GSYVideoPlayer;
import com.test.chao.jartest.R;
import com.test.chao.jartest.adapter.RecommendPageAdapter;
import com.test.chao.jartest.bean.BuDeJieContentListModel;
import com.test.chao.jartest.contract.RecommendContract;
import com.test.chao.jartest.contract.impl.RecommendPresenter;
import com.view.refresh.BGAStickinessRefreshViewHolder;
import com.view.refresh.PullRefreshLayout;

import org.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * 首页-推荐
 * Created by Chao on 2017/4/1.
 */

public class TabFragment_Recommend extends BaseFragment<RecommendContract.Presenter> implements RecommendContract.View, PullRefreshLayout.BGARefreshLayoutDelegate {

    RecommendPageAdapter adapter;
    @ViewInject(R.id.recycler)
    RecyclerView recycler;
    @ViewInject(R.id.refresh)
    PullRefreshLayout refresh;
    LinearLayoutManager manager;

    public static TabFragment_Recommend newInstance() {
        Bundle args = new Bundle();
        TabFragment_Recommend fragment = new TabFragment_Recommend();
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
        new RecommendPresenter(this);
        mPresenter.start();
    }

    @Override
    public void initData() {
        manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(manager);
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.addItemDecoration(new DividerItemDecoration(context, LinearLayout.VERTICAL));
        adapter = new RecommendPageAdapter(context, null, null);
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
        recycler.addOnScrollListener(new RecyclerView.OnScrollListener() {

            int firstVisibleItem, lastVisibleItem;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                firstVisibleItem = manager.findFirstVisibleItemPosition();
                lastVisibleItem = manager.findLastVisibleItemPosition();
                //大于0说明有播放
                if (GSYVideoManager.instance().getPlayPosition() >= 0) {
                    //当前播放的位置
                    int position = GSYVideoManager.instance().getPlayPosition();
                    //对应的播放列表TAG
                    if (GSYVideoManager.instance().getPlayTag().equals(RecommendPageAdapter.TAG)
                            && (position < firstVisibleItem || position > lastVisibleItem)) {
                        //如果滑出去了上面和下面就是否，和今日头条一样
                        GSYVideoPlayer.releaseAllVideos();
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }

    @Override
    public void showContent(List<BuDeJieContentListModel> list) {
        adapter.setData(list);
        stop();
    }

    @Override
    public void loadMoreContent(List<BuDeJieContentListModel> list) {
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
