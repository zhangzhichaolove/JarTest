package com.test.chao.jartest.api;

import com.test.chao.jartest.bean.BuDeJieContentModel;
import com.test.chao.jartest.bean.CommentDetailsModel;

import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * 笑话API
 */
public interface BuDeJieApi {

    String BASE_URL = "http://s.budejie.com/topic/list/jingxuan/1/budejie-android-6.5.11/0-20.json/";

    @GET
    Observable<BuDeJieContentModel> getBuDeJieData(@Url String url);

    @GET
    Observable<CommentDetailsModel> getBuDeJieComment(@Url String url);

}