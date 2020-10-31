package com.mp.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * (Area)表实体类
 *
 * @author makejava
 * @since 2020-10-25 16:21:28
 */
@SuppressWarnings("serial")
@TableName(value="area")
@Data
public class Area extends Model<Area> {

    private Integer id;

    private String name;

}