package com.test.chao.jartest.api;

import com.chao.system.LogUtils;
import com.test.chao.jartest.bean.HttpResult;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;
import rx.exceptions.OnErrorNotImplementedException;

/**
 * 自定义-观察者：
 *
 * @param <T>
 */
public abstract class HttpResultSubscriber<T> extends Subscriber<HttpResult<T>> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        LogUtils.showTagE(e);
        e.printStackTrace();
        //在这里做全局的错误处理
        if (e instanceof HttpException) {
            // ToastUtils.getInstance().showToast(e.getMessage());
            LogUtils.showTagE("HttpResultSubscriber", "网络异常");
        }
        if (e instanceof OnErrorNotImplementedException) {
            LogUtils.showTagE("HttpResultSubscriber", "错误没有实现异常");
        }
        if (e instanceof ClassCastException) {
            LogUtils.showTagE("HttpResultSubscriber", "类转换异常");
        }
        _onError(e);
    }

    @Override
    public void onNext(HttpResult<T> t) {
        if (t.getError_code() == 0)
            onSuccess(t.getResult());
        else
            _onError(new Throwable("error=" + t.getError_code()));
    }

    public abstract void onSuccess(HttpResult.ResultBean<T> t);

    public abstract void _onError(Throwable e);
}