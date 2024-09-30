package com.nuc.orderservice.controller;

import com.nuc.orderservice.pojo.Order;
import com.nuc.orderservice.pojo.R;
import com.nuc.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

   @Autowired
   private OrderService orderService;

    @GetMapping("{orderId}")
    public R queryOrderByUserId(@PathVariable("orderId") Long orderId) {
        // 根据id查询订单并返回
        Order order = orderService.queryOrderById(orderId);
        return R.ok().data(order);
    }
}