package com.kuang.service.impl;

import com.github.pagehelper.PageHelper;
import com.kuang.dao.OrdersMapper;
import com.kuang.dao.ProductMapper;
import com.kuang.dao.TravellersMapper;
import com.kuang.dao.UserMapper;
import com.kuang.pojo.Orders;
import com.kuang.pojo.Product;
import com.kuang.pojo.Traveller;
import com.kuang.pojo.UserInfo;
import com.kuang.service.OrdersService;
import com.kuang.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Date;
import java.util.List;

public class OrdersServiceImpl implements OrdersService {

    private OrdersMapper ordersMapper;
    private ProductMapper productMapper;
    private UserMapper userMapper;
    private TravellersMapper travellersMapper;

    public void setProductMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void setTravellersMapper(TravellersMapper travellersMapper) {
        this.travellersMapper = travellersMapper;
    }

    public void setOrdersMapper(OrdersMapper ordersMapper) {
        this.ordersMapper = ordersMapper;
    }

    @Override
    public Orders findById(String orderId) throws Exception {
        return ordersMapper.findById(orderId);
    }

    @Override
    public List<Orders> findAll(int page,int size) throws Exception {
        //第一个参数 页码 第二个参数 每页查询条数
        PageHelper.startPage(page,size);
      return ordersMapper.findAll();
    }



    @Override
    public Orders addOrder(int peopleCount, int productId, String uid) throws Exception {
        Orders orders = new Orders();
        // 创建一个订单对象
        orders.setOrderNum(UuidUtil.getUuid());
        orders.setOrderTime(new Date());
        orders.setPeopleCount(peopleCount);
        Product productById = productMapper.findProductById(productId);
        orders.setProduct(productById);
        orders.setProductId(String.valueOf(productId)); // 设置该单产品的id
        UserInfo byUserId = userMapper.findByUserId(uid);
        orders.setUserInfo(byUserId);
        orders.setUserId(byUserId.getId());
        orders.setOrderPrice(peopleCount*productById.getProductPrice());
        ordersMapper.addOrder(orders);
        // 可以通过该订单的orderNum获取该订单
        return orders;

    }

    @Override
    public void addOrderWithTravellers(List<Traveller> travellers, Orders orders) throws Exception {
        // 先将这些旅客保存下来
        addTravellers(travellers);

        // 获取订单，逐个让traveller与其连接
        Orders orderByOrderNum = ordersMapper.findOrderByOrderNum(orders.getOrderNum());
        for (Traveller traveller : travellers) {
            Traveller travellerByIdentifyCard = travellersMapper.findTravellerByIdentifyCard(traveller.getCredentialsNum());

            ordersMapper.connectOrderAndTraveller(orderByOrderNum.getId(),travellerByIdentifyCard.getId());
        }

    }

    @Override
    public void payFinished(String orderNum, String payType) {

        ordersMapper.payFinished(orderNum,payType);
    }

    @Override
    public List<Orders > findOrderByUserId(String uid) {
        return ordersMapper.findOrderByUserId(uid);
    }

    public void addTravellers(List<Traveller> travellers) throws Exception {
        for (Traveller traveller : travellers) {
            if (travellersMapper.findTravellerByIdentifyCard(traveller.getCredentialsNum())!=null)
            {
                // 存在
                continue;
            }
            travellersMapper.addTraveller(traveller);

        }

    }
}
