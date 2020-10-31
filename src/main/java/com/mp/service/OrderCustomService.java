package com.mp.service;

import com.mp.bo.OrderBO;

import java.util.List;

/**
 * (TOrderItem1)表服务接口
 *
 * @author makejava
 * @since 2020-10-25 16:43:30
 */
public interface OrderCustomService {
    /**
     * 根据订单好查询订单详细
     * @param orderId
     * @return
     */
    public List<OrderBO> getOrderInfos(long orderId);

}