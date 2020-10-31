package com.mp.dao;

import com.mp.bo.OrderBO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TOrder1)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-25 12:25:19
 */
public interface OrderCustomMapper {

    public List<OrderBO> selectOrderInfos(@Param("orderId") long orderId);

}