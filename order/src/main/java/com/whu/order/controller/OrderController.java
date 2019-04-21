package com.whu.order.controller;

import com.google.gson.Gson;
import com.whu.order.dto.UserOrder;
import com.whu.order.entity.OrderInfo;
import com.whu.order.entity.Receive;
import com.whu.order.enums.OrderEnum;
import com.whu.order.exception.OrderException;
import com.whu.order.service.OrderService;
import com.whu.order.vo.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private Gson gson;


    @RequestMapping("/myOrderList")
    public ResponseInfo myOrderList(@RequestBody String data) {
        Map<String,String> requestInfo = gson.fromJson(data,Map.class);
        String userId = requestInfo.get("userId");
        String orderStatus = requestInfo.get("orderStatus");
        Integer page = Integer.valueOf(requestInfo.get("page"));
        Integer size = Integer.valueOf(requestInfo.get("size"));
        List<UserOrder> userOrderList = orderService.findOrderList(userId,orderStatus,page-1,size);
        return new ResponseInfo(userOrderList);
    }

    @RequestMapping("/order_create")
    public ResponseInfo create(@RequestBody String data, HttpSession httpSession){

        Object userId = httpSession.getAttribute("userId");
        //判断用户是否登陆
        if(userId==null)
            throw new OrderException(OrderEnum.USER_NOT_LOGIN);
        Receive receive = gson.fromJson(data,Receive.class);
        OrderInfo orderInfo = gson.fromJson(data,OrderInfo.class);
        orderInfo.setUserId(userId.toString());
        OrderInfo order = orderService.create(orderInfo,receive);
        return new ResponseInfo(order.getOrderId());
    }

}
