package com.test.chao.jartest.bean;

import java.util.List;

/**
 * 创建日期：2017/5/1 on 13:34
 * 描述:
 * 作者:张智超 Chao
 */
public class BuDeJieContentListModel {

    /**
     * status : 4
     * comment : 15
     * top_comments : [{"voicetime":0,"status":0,"hate_count":0,"cmt_type":"text","precid":0,"content":"大黄蜂：擎天柱老铁，你撞错人了啊","like_count":8,"u":{"header":["http://qzapp.qlogo.cn/qzapp/100336987/AB26A33509BF289265C3B66DE09EE2E4/100","http://qzapp.qlogo.cn/qzapp/100336987/AB26A33509BF289265C3B66DE09EE2E4/100"],"uid":"20416294","is_vip":false,"room_url":"","sex":"m","room_name":"","room_role":"","room_icon":"","name":"用户613681"},"preuid":0,"passtime":"2017-05-01 13:11:37","voiceuri":"","id":79330549}]
     * tags : [{"id":55,"name":"微视频"},{"id":60,"name":"吐槽"},{"id":129,"name":"汽车"},{"id":156,"name":"牛人"}]
     * bookmark : 6
     * text : 这逼让你装得差点我就双击666了
     * up : 125
     * share_url : http://a.f.budejie.com/share/24786336.html?wx.qq.com
     * down : 19
     * forward : 25
     * u : {"header":["http://wimg.spriteapp.cn/profile/large/2016/07/13/578622c0e3a40_mini.jpg","http://dimg.spriteapp.cn/profile/large/2016/07/13/578622c0e3a40_mini.jpg"],"uid":"14401634","is_vip":false,"is_v":false,"room_url":"","room_name":"","room_role":"","room_icon":"","name":"白锤子"}
     * passtime : 2017-05-01 13:02:01
     * video : {"playfcount":1572,"height":400,"width":640,"video":["http://wvideo.spriteapp.cn/video/2017/0501/59060bd4763f5_wpd.mp4","http://dvideo.spriteapp.cn/video/2017/0501/59060bd4763f5_wpd.mp4"],"download":["http://wvideo.spriteapp.cn/video/2017/0501/59060bd4763f5_wpd.mp4","http://dvideo.spriteapp.cn/video/2017/0501/59060bd4763f5_wpd.mp4"],"duration":21,"playcount":6025,"thumbnail":["http://wimg.spriteapp.cn/picture/2017/0501/59060bd44c96e__b.jpg","http://dimg.spriteapp.cn/picture/2017/0501/59060bd44c96e__b.jpg"],"thumbnail_small":["http://wimg.spriteapp.cn/crop/150x150/picture/2017/0501/59060bd44c96e__b.jpg","http://dimg.spriteapp.cn/crop/150x150/picture/2017/0501/59060bd44c96e__b.jpg"]}
     * type : video
     * id : 24786336
     */

    private int status;
    private String comment;
    private String bookmark;
    private String text;
    private String up;
    private String share_url;
    private int down;
    private int forward;
    private UBean u;
    private String passtime;
    private String type;
    private String id;
    private List<TopCommentsBean> top_comments;
    private List<TagsBean> tags;
    private BuDeJieGif gif;
    private BuDeJieImage image;
    private BuDeJieVideo video;

    public BuDeJieGif getGif() {
        return gif;
    }

    public void setGif(BuDeJieGif gif) {
        this.gif = gif;
    }

    public BuDeJieImage getImage() {
        return image;
    }

    public void setImage(BuDeJieImage image) {
        this.image = image;
    }

    public BuDeJieVideo getVideo() {
        return video;
    }

    public void setVideo(BuDeJieVideo video) {
        this.video = video;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getBookmark() {
        return bookmark;
    }

    public void setBookmark(String bookmark) {
        this.bookmark = bookmark;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public int getForward() {
        return forward;
    }

    public void setForward(int forward) {
        this.forward = forward;
    }

    public UBean getU() {
        return u;
    }

    public void setU(UBean u) {
        this.u = u;
    }

    public String getPasstime() {
        return passtime;
    }

    public void setPasstime(String passtime) {
        this.passtime = passtime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<TopCommentsBean> getTop_comments() {
        return top_comments;
    }

    public void setTop_comments(List<TopCommentsBean> top_comments) {
        this.top_comments = top_comments;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public static class UBean {
        /**
         * header : ["http://wimg.spriteapp.cn/profile/large/2016/07/13/578622c0e3a40_mini.jpg","http://dimg.spriteapp.cn/profile/large/2016/07/13/578622c0e3a40_mini.jpg"]
         * uid : 14401634
         * is_vip : false
         * is_v : false
         * room_url :
         * room_name :
         * room_role :
         * room_icon :
         * name : 白锤子
         */

        private String uid;
        private boolean is_vip;
        private boolean is_v;
        private String room_url;
        private String room_name;
        private String room_role;
        private String room_icon;
        private String name;
        private List<String> header;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public boolean isIs_vip() {
            return is_vip;
        }

        public void setIs_vip(boolean is_vip) {
            this.is_vip = is_vip;
        }

        public boolean isIs_v() {
            return is_v;
        }

        public void setIs_v(boolean is_v) {
            this.is_v = is_v;
        }

        public String getRoom_url() {
            return room_url;
        }

        public void setRoom_url(String room_url) {
            this.room_url = room_url;
        }

        public String getRoom_name() {
            return room_name;
        }

        public void setRoom_name(String room_name) {
            this.room_name = room_name;
        }

        public String getRoom_role() {
            return room_role;
        }

        public void setRoom_role(String room_role) {
            this.room_role = room_role;
        }

        public String getRoom_icon() {
            return room_icon;
        }

        public void setRoom_icon(String room_icon) {
            this.room_icon = room_icon;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getHeader() {
            return header;
        }

        public void setHeader(List<String> header) {
            this.header = header;
        }
    }


    public static class TopCommentsBean {
        /**
         * voicetime : 0
         * status : 0
         * hate_count : 0
         * cmt_type : text
         * precid : 0
         * content : 大黄蜂：擎天柱老铁，你撞错人了啊
         * like_count : 8
         * u : {"header":["http://qzapp.qlogo.cn/qzapp/100336987/AB26A33509BF289265C3B66DE09EE2E4/100","http://qzapp.qlogo.cn/qzapp/100336987/AB26A33509BF289265C3B66DE09EE2E4/100"],"uid":"20416294","is_vip":false,"room_url":"","sex":"m","room_name":"","room_role":"","room_icon":"","name":"用户613681"}
         * preuid : 0
         * passtime : 2017-05-01 13:11:37
         * voiceuri :
         * id : 79330549
         */

        private int voicetime;
        private int status;
        private int hate_count;
        private String cmt_type;
        private int precid;
        private String content;
        private int like_count;
        private UBeanX u;
        private int preuid;
        private String passtime;
        private String voiceuri;
        private int id;

        public int getVoicetime() {
            return voicetime;
        }

        public void setVoicetime(int voicetime) {
            this.voicetime = voicetime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getHate_count() {
            return hate_count;
        }

        public void setHate_count(int hate_count) {
            this.hate_count = hate_count;
        }

        public String getCmt_type() {
            return cmt_type;
        }

        public void setCmt_type(String cmt_type) {
            this.cmt_type = cmt_type;
        }

        public int getPrecid() {
            return precid;
        }

        public void setPrecid(int precid) {
            this.precid = precid;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getLike_count() {
            return like_count;
        }

        public void setLike_count(int like_count) {
            this.like_count = like_count;
        }

        public UBeanX getU() {
            return u;
        }

        public void setU(UBeanX u) {
            this.u = u;
        }

        public int getPreuid() {
            return preuid;
        }

        public void setPreuid(int preuid) {
            this.preuid = preuid;
        }

        public String getPasstime() {
            return passtime;
        }

        public void setPasstime(String passtime) {
            this.passtime = passtime;
        }

        public String getVoiceuri() {
            return voiceuri;
        }

        public void setVoiceuri(String voiceuri) {
            this.voiceuri = voiceuri;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public static class UBeanX {
            /**
             * header : ["http://qzapp.qlogo.cn/qzapp/100336987/AB26A33509BF289265C3B66DE09EE2E4/100","http://qzapp.qlogo.cn/qzapp/100336987/AB26A33509BF289265C3B66DE09EE2E4/100"]
             * uid : 20416294
             * is_vip : false
             * room_url :
             * sex : m
             * room_name :
             * room_role :
             * room_icon :
             * name : 用户613681
             */

            private String uid;
            private boolean is_vip;
            private String room_url;
            private String sex;
            private String room_name;
            private String room_role;
            private String room_icon;
            private String name;
            private List<String> header;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public boolean isIs_vip() {
                return is_vip;
            }

            public void setIs_vip(boolean is_vip) {
                this.is_vip = is_vip;
            }

            public String getRoom_url() {
                return room_url;
            }

            public void setRoom_url(String room_url) {
                this.room_url = room_url;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getRoom_name() {
                return room_name;
            }

            public void setRoom_name(String room_name) {
                this.room_name = room_name;
            }

            public String getRoom_role() {
                return room_role;
            }

            public void setRoom_role(String room_role) {
                this.room_role = room_role;
            }

            public String getRoom_icon() {
                return room_icon;
            }

            public void setRoom_icon(String room_icon) {
                this.room_icon = room_icon;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<String> getHeader() {
                return header;
            }

            public void setHeader(List<String> header) {
                this.header = header;
            }
        }
    }

    public static class TagsBean {
        /**
         * id : 55
         * name : 微视频
         */

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
