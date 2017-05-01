package com.test.chao.jartest.bean;

import java.util.List;

/**
 * 创建日期：2017/5/1 on 13:35
 * 描述:
 * 作者:张智超 Chao
 */
public class BuDeJieContentModel {

    /**
     * info : {"count":4100,"np":1493602953}
     */

    private InfoBean info;
    private List<BuDeJieContentListModel> list;

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public List<BuDeJieContentListModel> getList() {
        return list;
    }

    public void setList(List<BuDeJieContentListModel> list) {
        this.list = list;
    }

    public static class InfoBean {
        /**
         * count : 4100
         * np : 1493602953
         */

        private int count;
        private int np;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getNp() {
            return np;
        }

        public void setNp(int np) {
            this.np = np;
        }
    }
}
