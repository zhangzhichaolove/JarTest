package com.test.chao.jartest.bean;

import java.util.List;

/**
 * Created by Chao on 2017/4/1.
 */

public class HttpResult<T> {

    private int error_code;
    private String reason;
    private ResultBean<T> result;

    public static class ResultBean<T> {
        private List<T> data;

        public List<T> getData() {
            return data;
        }

        public void setData(List<T> data) {
            this.data = data;
        }
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean<T> getResult() {
        return result;
    }

    public void setResult(ResultBean<T> result) {
        this.result = result;
    }
}
