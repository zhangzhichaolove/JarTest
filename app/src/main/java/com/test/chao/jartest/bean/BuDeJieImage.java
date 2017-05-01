package com.test.chao.jartest.bean;

import java.util.List;

/**
 * 创建日期：2017/5/1 on 16:12
 * 描述:
 * 作者:张智超 Chao
 */
public class BuDeJieImage {

    /**
     * medium : []
     * big : ["http://wimg.spriteapp.cn/ugc/2017/04/30/5905b57e7988f_1.jpg","http://dimg.spriteapp.cn/ugc/2017/04/30/5905b57e7988f_1.jpg"]
     * download_url : ["http://wimg.spriteapp.cn/ugc/2017/04/30/5905b57e7988f_d.jpg","http://dimg.spriteapp.cn/ugc/2017/04/30/5905b57e7988f_d.jpg","http://wimg.spriteapp.cn/ugc/2017/04/30/5905b57e7988f.jpg","http://dimg.spriteapp.cn/ugc/2017/04/30/5905b57e7988f.jpg"]
     * height : 2125
     * width : 750
     * small : []
     * thumbnail_small : ["http://wimg.spriteapp.cn/crop/150x150/ugc/2017/04/30/5905b57e7988f.jpg","http://dimg.spriteapp.cn/crop/150x150/ugc/2017/04/30/5905b57e7988f.jpg"]
     */

    private int height;
    private int width;
    private List<?> medium;
    private List<String> big;
    private List<String> download_url;
    private List<?> small;
    private List<String> thumbnail_small;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public List<?> getMedium() {
        return medium;
    }

    public void setMedium(List<?> medium) {
        this.medium = medium;
    }

    public List<String> getBig() {
        return big;
    }

    public void setBig(List<String> big) {
        this.big = big;
    }

    public List<String> getDownload_url() {
        return download_url;
    }

    public void setDownload_url(List<String> download_url) {
        this.download_url = download_url;
    }

    public List<?> getSmall() {
        return small;
    }

    public void setSmall(List<?> small) {
        this.small = small;
    }

    public List<String> getThumbnail_small() {
        return thumbnail_small;
    }

    public void setThumbnail_small(List<String> thumbnail_small) {
        this.thumbnail_small = thumbnail_small;
    }
}
