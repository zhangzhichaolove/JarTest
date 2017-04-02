package com.test.chao.jartest.contract;


import com.chao.mvp.BasePresenter;
import com.chao.mvp.BaseView;
import com.test.chao.jartest.bean.JokeListBean;

import java.util.List;

/**
 * Description: TabFragmentContract
 */
public interface TabFragmentContract {

    interface View extends BaseView<Presenter> {


        void showContent(List<JokeListBean> list);

        void loadMoreContent(List<JokeListBean> list);

    }

    interface Presenter extends BasePresenter {

        void onRefresh();

        void loadMore();


    }
}
