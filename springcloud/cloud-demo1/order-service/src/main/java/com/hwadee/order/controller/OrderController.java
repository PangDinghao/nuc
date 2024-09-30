package com.hwadee.order.controller;


import com.hwadee.order.pojo.Order;
import com.hwadee.order.pojo.R;
import com.hwadee.order.service.OrderService;
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
