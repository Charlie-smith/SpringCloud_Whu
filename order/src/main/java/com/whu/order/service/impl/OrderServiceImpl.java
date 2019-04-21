package com.whu.order.service.impl;

import com.google.gson.Gson;
import com.whu.order.dto.UserOrder;
import com.whu.order.entity.OrderInfo;
import com.whu.order.entity.Receive;
import com.whu.order.exception.OrderException;
import com.whu.order.feign.ProductFeign;
import com.whu.order.repository.OrderInfoRepository;
import com.whu.order.repository.ReceiveRepository;
import com.whu.order.service.OrderService;
import com.whu.order.vo.ResponseInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private ReceiveRepository receiveRepository;

    @Autowired
    private OrderInfoRepository orderInfoRepository;

    @Autowired
    private ProductFeign productFeign;

    @Autowired
    private Gson gson;

    @Override
    @Transactional
    public OrderInfo create(OrderInfo orderInfo, Receive receive) {
        Receive receiver = receiveRepository.save(receive);
        orderInfo.setReceiveId(receiver.getReceiveId());
        orderInfo.setOrderId(UUID.randomUUID().toString());
        orderInfo.setOrderStatus("0");
        //扣库存
        Map<String, String> map = new HashMap<>();
        map.put("productId", orderInfo.getProductId().toString());
        map.put("stockChange", orderInfo.getProductNum().toString());
        ResponseInfo ProductCall = productFeign.updateStock(gson.toJson(map));
        if(ProductCall.getCode()!=0)
            throw new OrderException(ProductCall.getCode(),ProductCall.getMsg());
        return orderInfoRepository.save(orderInfo);
    }

    @Override
    public List<UserOrder> findOrderList(String userId, String orderStatus, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<OrderInfo> orderInfoList = orderInfoRepository.findByUserIdAndOrderStatus(userId,orderStatus,pageable);
        List<UserOrder> orderList = new ArrayList<>();
        for(OrderInfo order : orderInfoList.getContent()){
            Map<String,String> map = new HashMap<>();
            map.put("productId",order.getProductId().toString());
            ResponseInfo product = productFeign.information(gson.toJson(map));
            if(product.getCode()!=0)
                throw new OrderException(product.getCode(),product.getMsg());
            UserOrder userOrder = new UserOrder();
            BeanUtils.copyProperties(order,userOrder);
            userOrder.setProductName(((Map)product.getData()).get("productName").toString());
            userOrder.setProductPrice((Double)((Map)product.getData()).get("productPrice"));
            orderList.add(userOrder);
        }

        return orderList;
    }
}
