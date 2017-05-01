package com.test.chao.jartest.contract.impl;

import android.support.annotation.NonNull;

import com.chao.mvp.BasePresenterImpl;
import com.chao.net.RxUtils;
import com.chao.net.ServiceFactory;
import com.test.chao.jartest.api.BuDeJieApi;
import com.test.chao.jartest.bean.CommentDetailsModel;
import com.test.chao.jartest.contract.CommentDetailsContract;

import rx.functions.Action1;

/**
 * Created by Chao on 2017/4/1.
 */

public class CommentDetailsPresenter extends BasePresenterImpl<CommentDetailsContract.View> implements CommentDetailsContract.Presenter {
    private int page = 0;

    public CommentDetailsPresenter(@NonNull CommentDetailsContract.View view) {
        super(view);
    }


    @Override
    public void onRefresh() {
        page = 0;
        start();
    }

    @Override
    public void loadMore() {
        page++;
        start();
    }

    @Override
    public void start() {
        ServiceFactory.getInstance().createService(BuDeJieApi.class).getBuDeJieComment("http://api.budejie.com/api/api_open.php?a=dataList&c=comment&data_id=" + view.getId())
                .compose(RxUtils.<CommentDetailsModel>defaultSchedulers()).subscribe(new Action1<CommentDetailsModel>() {
            @Override
            public void call(CommentDetailsModel commentDetailsModel) {
                if (page == 0) {
                    view.showContent(commentDetailsModel.getData());
                } else {
                    view.loadMoreContent(commentDetailsModel.getData());
                }
                //page = contentModel.getInfo().getNp();
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
