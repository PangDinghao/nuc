package com.hwadee.order.service;


import com.hwadee.order.feign.UserClient;
import com.hwadee.order.mapper.OrderMapper;
import com.hwadee.order.pojo.Order;
import com.hwadee.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    UserClient  userClient;


    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        User user = userClient.findById(order.getUserId());
        order.setUser(user);
        // 4.返回
        return order;
    }
}