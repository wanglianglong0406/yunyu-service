package com.mp.service.impl;

import com.mp.entity.Order;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mp.dao.OrderMapper;
import com.mp.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * (TOrder1)表服务实现类
 *
 * @author makejava
 * @since 2020-10-25 12:25:19
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Resource
    OrderMapper orderMapper;

    @Override
    public void addOrder() {
        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setPrice(new BigDecimal(Math.random()));
            order.setUserId(new Random().nextLong());
            order.setStatus("0");
            orderMapper.insert(order);
        }
    }


    //执行新增后，将两库的数据各取一条，来测试
    @Override
    public void findOrder() {
        List<Long> list=new ArrayList<>();
        list.add(418415166183440384L);
        list.add(418417197166100481L);
        QueryWrapper<Order> queryWrapper=new QueryWrapper<>();
        queryWrapper.in("order_id", list);
        orderMapper.selectList(queryWrapper);
    }

}