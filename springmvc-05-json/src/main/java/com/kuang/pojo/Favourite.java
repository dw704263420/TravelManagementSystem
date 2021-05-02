package com.kuang.pojo;

import java.util.Date;

/**
 * 收藏关联表实体类
 */
public class Favourite {
    private String rid;
    private Date date;
    private String uid;

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
