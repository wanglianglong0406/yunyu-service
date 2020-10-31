package com.mp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * (TOrderItem1)表实体类
 *
 * @author makejava
 * @since 2020-10-25 16:43:30
 */
@SuppressWarnings("serial")
@Data
@TableName(value = "t_order_item")
public class OrderItem extends Model<OrderItem> {
    @TableId(type= IdType.ID_WORKER)
    private Long id;

    private Long orderId;

    private String produceName;

    private Integer num;

    private Long userId;



}