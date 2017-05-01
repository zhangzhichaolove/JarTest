package com.test.chao.jartest.contract;


import com.chao.mvp.BasePresenter;
import com.chao.mvp.BaseView;
import com.test.chao.jartest.bean.CommentDetailsDataModel;

import java.util.List;


public interface CommentDetailsContract {

    interface View extends BaseView<Presenter> {


        void showContent(List<CommentDetailsDataModel> list);

        void loadMoreContent(List<CommentDetailsDataModel> list);

        String getId();
    }

    interface Presenter extends BasePresenter {

        void onRefresh();

        void loadMore();


    }
}
