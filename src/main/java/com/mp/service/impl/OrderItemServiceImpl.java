package com.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mp.dao.OrderItemMapper;
import com.mp.entity.OrderItem;
import com.mp.service.OrderItemService;
import org.springframework.stereotype.Service;

/**
 * (TOrderItem1)表服务实现类
 *
 * @author makejava
 * @since 2020-10-25 16:43:31
 */
@Service("tOrderItem1Service")
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {

}