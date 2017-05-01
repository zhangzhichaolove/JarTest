package com.test.chao.jartest.bean;

import java.util.List;

/**
 * 创建日期：2017/5/1 on 17:35
 * 描述:
 * 作者:张智超 Chao
 */
public class CommentDetailsModel {
    private int total;
    private List<CommentDetailsDataModel> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<CommentDetailsDataModel> getData() {
        return data;
    }

    public void setData(List<CommentDetailsDataModel> data) {
        this.data = data;
    }
}
