package com.test.chao.jartest.contract.impl;

import com.base.utils.ToastUtils;
import com.chao.net.RxUtils;
import com.chao.net.ServiceFactory;
import com.test.chao.jartest.api.HttpResultSubscriber;
import com.test.chao.jartest.api.JokeApi;
import com.test.chao.jartest.api.RetrofitHelper;
import com.test.chao.jartest.bean.HttpResult;
import com.test.chao.jartest.bean.JokeListBean;
import com.test.chao.jartest.contract.TabFragmentContract;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Chao on 2017/4/1.
 */

public class TabFragmentPresenter implements TabFragmentContract.Presenter {
    TabFragmentContract.View view;
    private int page = 1;

    public TabFragmentPresenter(TabFragmentContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void onRefresh() {
        page = 1;
        start();
    }

    @Override
    public void loadMore() {
        page++;
        start();
    }

    @Override
    public void start() {
        ServiceFactory.getInstance().createService(JokeApi.class).getJokeList("8f3ad1265765e9f653df7d47ecfa68c8", 1, 20)
                .compose(RxUtils.<HttpResult<JokeListBean>>defaultSchedulers()).subscribe(new HttpResultSubscriber<JokeListBean>() {
            @Override
            public void onSuccess(HttpResult.ResultBean<JokeListBean> t) {
                view.showContent(t.getData());
            }

            @Override
            public void _onError(Throwable e) {
                ToastUtils.showCToast(e.toString());
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
