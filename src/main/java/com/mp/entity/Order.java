package com.mp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.math.BigDecimal;

/**
 * (TOrder1)表实体类
 *
 * @author makejava
 * @since 2020-10-25 12:25:18
 */
@Data
@TableName(value="t_order")
public class Order extends Model<Order> {

    /**
     * 订单id
     */
    @TableId(type= IdType.ID_WORKER)
    private Long orderId;

    /**
     * 订单价格
     */
    private BigDecimal price;

    /**
     * 下单用户id
     */
    private Long userId;

    /**
     * 订单状态
     */
    private String status;

}