package com.mp.controller;


import com.mp.bo.OrderBO;
import com.mp.service.OrderCustomService;
import com.mp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TOrder1)表控制层
 *
 * @author makejava
 * @since 2020-10-25 12:25:20
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Resource
    private OrderCustomService orderCustomService;

    @GetMapping(value = "/add")
    public void addOrder() {
        orderService.addOrder();
    }

    @GetMapping(value = "/find")
    public void findOrder() {
        List<OrderBO> orderList = orderCustomService.getOrderInfos(1320264024483815425l);
        orderList.forEach(System.err::println);
    }

}