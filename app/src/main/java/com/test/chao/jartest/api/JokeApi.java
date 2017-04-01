package com.test.chao.jartest.api;

import com.test.chao.jartest.bean.HttpResult;
import com.test.chao.jartest.bean.JokeListBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * 笑话API
 */
public interface JokeApi {

    String BASE_URL = "http://japi.juhe.cn/joke/";

    @GET("content/text.from")
    Observable<HttpResult<JokeListBean>> getJokeList(@Query("key") String key, @Query("page") int page, @Query("pagesize") int pagesize);

    @GET
    Observable<HttpResult<JokeListBean>> loadString(@Url String url);

}