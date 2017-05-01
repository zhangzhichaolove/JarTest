package com.test.chao.jartest.bean;

/**
 * 创建日期：2017/5/1 on 17:36
 * 描述:
 * 作者:张智超 Chao
 */
public class CommentDetailsDataModel {
    /**
     * data_id : 20565881
     * status : 0
     * id : 75650038
     * content : 韩国的妓女就是厉害ง •̀_•́ง
     * ctime : 2017-03-04 23:07:20
     * precid : 0
     * preuid : 0
     * like_count : 0
     * voiceuri :
     * voicetime :
     * cmt_type : 29
     * user : {"id":"12929536","username":"哪只妖精顶了朕","sex":"m","profile_image":"http://qzapp.qlogo.cn/qzapp/100336987/7A647FB934B450BC581932276DC6A919/100","weibo_uid":"","qq_uid":"","qzone_uid":"7A647FB934B450BC581932276DC6A919","is_vip":false,"personal_page":"http://user.qzone.qq.com/7A647FB934B450BC581932276DC6A919","total_cmt_like_count":"6890"}
     * precmt : []
     */

    private String data_id;
    private String status;
    private String id;
    private String content;
    private String ctime;
    private String precid;
    private String preuid;
    private String like_count;
    private String voiceuri;
    private String voicetime;
    private String cmt_type;
    private UserBean user;

    public String getData_id() {
        return data_id;
    }

    public void setData_id(String data_id) {
        this.data_id = data_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getPrecid() {
        return precid;
    }

    public void setPrecid(String precid) {
        this.precid = precid;
    }

    public String getPreuid() {
        return preuid;
    }

    public void setPreuid(String preuid) {
        this.preuid = preuid;
    }

    public String getLike_count() {
        return like_count;
    }

    public void setLike_count(String like_count) {
        this.like_count = like_count;
    }

    public String getVoiceuri() {
        return voiceuri;
    }

    public void setVoiceuri(String voiceuri) {
        this.voiceuri = voiceuri;
    }

    public String getVoicetime() {
        return voicetime;
    }

    public void setVoicetime(String voicetime) {
        this.voicetime = voicetime;
    }

    public String getCmt_type() {
        return cmt_type;
    }

    public void setCmt_type(String cmt_type) {
        this.cmt_type = cmt_type;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }


    public static class UserBean {
        /**
         * id : 12929536
         * username : 哪只妖精顶了朕
         * sex : m
         * profile_image : http://qzapp.qlogo.cn/qzapp/100336987/7A647FB934B450BC581932276DC6A919/100
         * weibo_uid :
         * qq_uid :
         * qzone_uid : 7A647FB934B450BC581932276DC6A919
         * is_vip : false
         * personal_page : http://user.qzone.qq.com/7A647FB934B450BC581932276DC6A919
         * total_cmt_like_count : 6890
         */

        private String id;
        private String username;
        private String sex;
        private String profile_image;
        private String weibo_uid;
        private String qq_uid;
        private String qzone_uid;
        private boolean is_vip;
        private String personal_page;
        private String total_cmt_like_count;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getProfile_image() {
            return profile_image;
        }

        public void setProfile_image(String profile_image) {
            this.profile_image = profile_image;
        }

        public String getWeibo_uid() {
            return weibo_uid;
        }

        public void setWeibo_uid(String weibo_uid) {
            this.weibo_uid = weibo_uid;
        }

        public String getQq_uid() {
            return qq_uid;
        }

        public void setQq_uid(String qq_uid) {
            this.qq_uid = qq_uid;
        }

        public String getQzone_uid() {
            return qzone_uid;
        }

        public void setQzone_uid(String qzone_uid) {
            this.qzone_uid = qzone_uid;
        }

        public boolean isIs_vip() {
            return is_vip;
        }

        public void setIs_vip(boolean is_vip) {
            this.is_vip = is_vip;
        }

        public String getPersonal_page() {
            return personal_page;
        }

        public void setPersonal_page(String personal_page) {
            this.personal_page = personal_page;
        }

        public String getTotal_cmt_like_count() {
            return total_cmt_like_count;
        }

        public void setTotal_cmt_like_count(String total_cmt_like_count) {
            this.total_cmt_like_count = total_cmt_like_count;
        }
    }
}
