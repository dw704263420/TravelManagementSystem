package com.kuang.pojo;

import com.kuang.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 产品实体类
 */
public class Product {
    private String id; // 主键
    private String productNum; // 产品编号 唯一
    private String productName; // 产品名称
    private String cityName; // 出发城市
    @DateTimeFormat(pattern = "yyyy-MM-dd Hh:mm:ss")
    private Date departureTime; // 出发时间 这种类型转换是局部处理方式
    private String departureTimeStr; // 时间 格式化 字符串
    private Double productPrice;
    private String productDesc; // 产品描述
    private Integer productStatus; //产品状态 0关闭 1开启
    private String productStatusStr; // 状态格式化 字符串
    private Integer isThemeTour;
    private Integer counts;
    private String cid;
    private String rimage;
    private String sid;
    private String sourceId;
    private Category category;//所属分类
    private Seller seller;//所属商家
    private List<RouteImg> routeImgList;//商品详情图片列表
    private Integer isFavourTimes;

    public Integer getIsFavourTimes() {
        return isFavourTimes;
    }

    public void setIsFavourTimes(Integer isFavourTimes) {
        this.isFavourTimes = isFavourTimes;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public List<RouteImg> getRouteImgList() {
        return routeImgList;
    }

    public void setRouteImgList(List<RouteImg> routeImgList) {
        this.routeImgList = routeImgList;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getIsThemeTour() {
        return isThemeTour;
    }

    public void setIsThemeTour(Integer isThemeTour) {
        this.isThemeTour = isThemeTour;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getRimage() {
        return rimage;
    }

    public void setRimage(String rimage) {
        this.rimage = rimage;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTimeStr() {
        if(departureTime!=null){
            departureTimeStr= DateUtils.date2String(departureTime,"yyyy-MM-dd HH:mm:ss");
        }
        return departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        if (productStatus != null) {
            // 状态 0 关闭 1 开启
            if(productStatus==0)
            {
                productStatusStr="关闭";
            }
            if(productStatus==1)
            {
                productStatusStr="开启";
            }
        }
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", departureTime=" + departureTime +
                ", departureTimeStr='" + departureTimeStr + '\'' +
                ", productPrice=" + productPrice +
                ", productDesc='" + productDesc + '\'' +
                ", productStatus=" + productStatus +
                ", productStatusStr='" + productStatusStr + '\'' +
                ", isThemeTour=" + isThemeTour +
                ", counts=" + counts +
                ", cid='" + cid + '\'' +
                ", rimage='" + rimage + '\'' +
                ", sid='" + sid + '\'' +
                ", sourceId='" + sourceId + '\'' +
                ", category=" + category +
                ", seller=" + seller +
                ", routeImgList=" + routeImgList +
                ", isFavourTimes=" + isFavourTimes +
                '}';
    }
}
