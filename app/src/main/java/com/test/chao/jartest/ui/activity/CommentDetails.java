package com.test.chao.jartest.ui.activity;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chao.base.BaseActivity;
import com.test.chao.jartest.R;
import com.test.chao.jartest.adapter.CommentDetailsAdapter;
import com.test.chao.jartest.bean.CommentDetailsDataModel;
import com.test.chao.jartest.contract.CommentDetailsContract;
import com.test.chao.jartest.contract.impl.CommentDetailsPresenter;
import com.view.refresh.BGAStickinessRefreshViewHolder;
import com.view.refresh.PullRefreshLayout;

import org.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * 创建日期：2017/5/1 on 17:25
 * 描述:
 * 作者:张智超 Chao
 */
public class CommentDetails extends BaseActivity<CommentDetailsContract.Presenter> implements CommentDetailsContract.View, PullRefreshLayout.BGARefreshLayoutDelegate {
    CommentDetailsAdapter adapter;
    @ViewInject(R.id.recycler)
    RecyclerView recycler;
    @ViewInject(R.id.refresh)
    PullRefreshLayout refresh;

    @Override
    public int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initTopBar(View layout, TextView finish, TextView title, View... other) {
        title.setText("评论详情");
    }

    @Override
    public void initView() {
        new CommentDetailsPresenter(this);
        mPresenter.start();
    }

    @Override
    public void initData() {
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(manager);
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.addItemDecoration(new DividerItemDecoration(context, LinearLayout.VERTICAL));
        adapter = new CommentDetailsAdapter(context, null, R.layout.item_comment_details);
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
    public void initListener() {
        refresh.setDelegate(this);
        refresh.setPullDownRefreshEnable(true);
        refresh.setIsShowLoadingMoreView(true);
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

    @Override
    public void showContent(List<CommentDetailsDataModel> list) {
        adapter.setData(list);
        stop();
    }

    @Override
    public void loadMoreContent(List<CommentDetailsDataModel> list) {
        adapter.addAll(list);
        stop();
    }

    @Override
    public String getId() {
        return getIntent().getStringExtra("id");
    }
}
