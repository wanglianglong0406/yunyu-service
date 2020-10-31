package com.mp.service;

import com.mp.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * (TOrder1)表服务接口
 *
 * @author makejava
 * @since 2020-10-25 12:25:19
 */
public interface OrderService extends IService<Order> {

    /**
     * 新增订单
     *
     */
    void addOrder();

    /**
     * 查询
     */
    void findOrder();


}