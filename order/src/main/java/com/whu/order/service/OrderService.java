package com.whu.order.service;

import com.whu.order.dto.UserOrder;
import com.whu.order.entity.OrderInfo;
import com.whu.order.entity.Receive;

import java.util.List;

public interface OrderService {

    OrderInfo create(OrderInfo orderInfo, Receive receive);

    List<UserOrder> findOrderList(String userId, String orderStatus, Integer page, Integer size);

}
