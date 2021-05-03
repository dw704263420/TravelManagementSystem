package com.kuang.pojo;

/**
 * 轮播图实体类
 */
public class Banner {
    String bid;
    String bImage;

    public Banner() {
    }

    public Banner(String bid, String bImage) {
        this.bid = bid;
        this.bImage = bImage;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getbImage() {
        return bImage;
    }

    public void setbImage(String bImage) {
        this.bImage = bImage;
    }
}
