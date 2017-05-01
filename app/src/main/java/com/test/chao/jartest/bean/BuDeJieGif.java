package com.test.chao.jartest.bean;

import java.util.List;

/**
 * 创建日期：2017/5/1 on 14:22
 * 描述:
 * 作者:张智超 Chao
 */
public class BuDeJieGif {

    /**
     * images : ["http://wimg.spriteapp.cn/ugc/2017/04/30/590606ada0bf9.gif","http://dimg.spriteapp.cn/ugc/2017/04/30/590606ada0bf9.gif"]
     * width : 208
     * gif_thumbnail : ["http://wimg.spriteapp.cn/ugc/2017/04/30/590606ada0bf9_a_1.jpg","http://dimg.spriteapp.cn/ugc/2017/04/30/590606ada0bf9_a_1.jpg"]
     * download_url : ["http://wimg.spriteapp.cn/ugc/2017/04/30/590606ada0bf9_d.jpg","http://dimg.spriteapp.cn/ugc/2017/04/30/590606ada0bf9_d.jpg","http://wimg.spriteapp.cn/ugc/2017/04/30/590606ada0bf9_a_1.jpg","http://dimg.spriteapp.cn/ugc/2017/04/30/590606ada0bf9_a_1.jpg"]
     * height : 282
     */

    private int width;
    private int height;
    private List<String> images;
    private List<String> gif_thumbnail;
    private List<String> download_url;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getGif_thumbnail() {
        return gif_thumbnail;
    }

    public void setGif_thumbnail(List<String> gif_thumbnail) {
        this.gif_thumbnail = gif_thumbnail;
    }

    public List<String> getDownload_url() {
        return download_url;
    }

    public void setDownload_url(List<String> download_url) {
        this.download_url = download_url;
    }
}
