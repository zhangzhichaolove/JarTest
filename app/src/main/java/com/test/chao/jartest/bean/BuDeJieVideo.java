package com.test.chao.jartest.bean;

import java.util.List;

/**
 * 创建日期：2017/5/1 on 14:24
 * 描述:
 * 作者:张智超 Chao
 */
public class BuDeJieVideo {

    /**
     * playfcount : 1572
     * height : 400
     * width : 640
     * video : ["http://wvideo.spriteapp.cn/video/2017/0501/59060bd4763f5_wpd.mp4","http://dvideo.spriteapp.cn/video/2017/0501/59060bd4763f5_wpd.mp4"]
     * download : ["http://wvideo.spriteapp.cn/video/2017/0501/59060bd4763f5_wpd.mp4","http://dvideo.spriteapp.cn/video/2017/0501/59060bd4763f5_wpd.mp4"]
     * duration : 21
     * playcount : 6025
     * thumbnail : ["http://wimg.spriteapp.cn/picture/2017/0501/59060bd44c96e__b.jpg","http://dimg.spriteapp.cn/picture/2017/0501/59060bd44c96e__b.jpg"]
     * thumbnail_small : ["http://wimg.spriteapp.cn/crop/150x150/picture/2017/0501/59060bd44c96e__b.jpg","http://dimg.spriteapp.cn/crop/150x150/picture/2017/0501/59060bd44c96e__b.jpg"]
     */

    private int playfcount;
    private int height;
    private int width;
    private int duration;
    private int playcount;
    private List<String> video;
    private List<String> download;
    private List<String> thumbnail;
    private List<String> thumbnail_small;

    public int getPlayfcount() {
        return playfcount;
    }

    public void setPlayfcount(int playfcount) {
        this.playfcount = playfcount;
    }

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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPlaycount() {
        return playcount;
    }

    public void setPlaycount(int playcount) {
        this.playcount = playcount;
    }

    public List<String> getVideo() {
        return video;
    }

    public void setVideo(List<String> video) {
        this.video = video;
    }

    public List<String> getDownload() {
        return download;
    }

    public void setDownload(List<String> download) {
        this.download = download;
    }

    public List<String> getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(List<String> thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<String> getThumbnail_small() {
        return thumbnail_small;
    }

    public void setThumbnail_small(List<String> thumbnail_small) {
        this.thumbnail_small = thumbnail_small;
    }
}
