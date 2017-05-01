package com.test.chao.jartest.contract;


import com.chao.mvp.BasePresenter;
import com.chao.mvp.BaseView;
import com.test.chao.jartest.bean.BuDeJieContentListModel;

import java.util.List;

/**
 * Description: TabFragmentContract
 */
public interface RecommendContract {

    interface View extends BaseView<Presenter> {


        void showContent(List<BuDeJieContentListModel> list);

        void loadMoreContent(List<BuDeJieContentListModel> list);

    }

    interface Presenter extends BasePresenter {

        void onRefresh();

        void loadMore();


    }
}
