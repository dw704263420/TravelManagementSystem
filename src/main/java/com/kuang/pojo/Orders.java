package com.kuang.pojo;

import com.kuang.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * 订单实体类
 */
public class Orders {
    private  String id;
    private  String orderNum;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date orderTime;
    private  String orderTimeStr;
    private  int orderStatus;
    private String orderStatusStr;
    private  int peopleCount;
    private Product product;
    private List<Traveller> travellers;
    private Member member;
    private  Integer payType;
    private String payTypeStr;
    private String orderDesc;




    public Orders(String id, String orderNum, Date orderTime, String orderTimeStr, int orderStatus, String orderStatusStr, int peopleCount, Product product, List<Traveller> travellers, Member member, Integer payType, String payTypeStr, String orderDesc) {
        this.id = id;
        this.orderNum = orderNum;
        this.orderTime = orderTime;
        this.orderTimeStr = orderTimeStr;
        this.orderStatus = orderStatus;
        this.orderStatusStr = orderStatusStr;
        this.peopleCount = peopleCount;
        this.product = product;
        this.travellers = travellers;
        this.member = member;
        this.payType = payType;
        this.payTypeStr = payTypeStr;
        this.orderDesc = orderDesc;
    }

    public Orders() {
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getOrderStatusStr() {
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if(orderTime!=null)
        {
            orderTimeStr= DateUtils.date2String(orderTime,"yyyy-MM-dd hh:mm");
        }
        return orderTimeStr;
    }

    public String getPayTypeStr() {
        // 支付方式：0支付宝 1微信 2其他
        if(payType==0)
        {
            payTypeStr="支付宝支付";
        }else if(payType ==1)
        {
            payTypeStr="微信支付";
        }else if(payType==2)
        {
            payTypeStr="第三方支付";
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public int getOrderStatus() {
        if(orderStatus==0)
        {
            orderTimeStr="未支付";
        }
        if (orderStatus==1)
        {
            orderTimeStr="已支付";
        }
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getPropleCount() {
        return peopleCount;
    }

    public void setPropleCount(int propleCount) {
        this.peopleCount = propleCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", orderStatus=" + orderStatus +
                ", peopleCount=" + peopleCount +
                ", product=" + product +
                ", travellers=" + travellers +
                ", payType=" + payType +
                ", orderDesc='" + orderDesc + '\'' +
                ", orderStatusStr='" + orderStatusStr + '\'' +
                '}';
    }
}
