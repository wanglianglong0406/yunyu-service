package com.mp.service.impl;

import com.mp.bo.OrderBO;
import com.mp.dao.OrderCustomMapper;
import com.mp.service.OrderCustomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class OrderCustomServiceImpl implements OrderCustomService {
    @Resource
    private OrderCustomMapper orderCustomMapper;

    @Override
    public List<OrderBO> getOrderInfos(long orderId) {
        return orderCustomMapper.selectOrderInfos(orderId);
    }
}
