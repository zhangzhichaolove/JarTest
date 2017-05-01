package com.test.chao.jartest.contract.impl;

import android.support.annotation.NonNull;

import com.chao.mvp.BasePresenterImpl;
import com.chao.net.RxUtils;
import com.chao.net.ServiceFactory;
import com.test.chao.jartest.api.BuDeJieApi;
import com.test.chao.jartest.bean.BuDeJieContentModel;
import com.test.chao.jartest.contract.RecommendContract;

import rx.functions.Action1;

/**
 * Created by Chao on 2017/4/1.
 */

public class RecommendPresenter extends BasePresenterImpl<RecommendContract.View> implements RecommendContract.Presenter {
    private long page = 0;

    public RecommendPresenter(@NonNull RecommendContract.View view) {
        super(view);
    }


    @Override
    public void onRefresh() {
        page = 0;
        start();
    }

    @Override
    public void loadMore() {
        start();
    }

    @Override
    public void start() {
        ServiceFactory.getInstance().createService(BuDeJieApi.class).getBuDeJieData("http://s.budejie.com/topic/list/jingxuan/1/budejie-android-6.5.11/" + page + "-20.json")
                .compose(RxUtils.<BuDeJieContentModel>defaultSchedulers()).subscribe(new Action1<BuDeJieContentModel>() {
            @Override
            public void call(BuDeJieContentModel contentModel) {
                if (page == 0) {
                    view.showContent(contentModel.getList());
                } else {
                    view.loadMoreContent(contentModel.getList());
                }
                page = contentModel.getInfo().getNp();
            }
        });
//        RetrofitHelper.getJokeApi().getJokeList("8f3ad1265765e9f653df7d47ecfa68c8", 1, 20).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new HttpResultSubscriber<JokeListBean>() {
//                    @Override
//                    public void onSuccess(HttpResult.ResultBean<JokeListBean> t) {
//                        view.showContent(t.getData());
//                    }
//
//                    @Override
//                    public void _onError(Throwable e) {
//                        ToastUtils.showTagE(e);
//                    }
//                });
    }
}
