package com.mp.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
public class User extends Model<User> {

    private static final long serialVersionUID=1L;
    //主键
    @TableId(type= IdType.AUTO)
    private Long userId;
    //姓名

    @TableField(condition = SqlCondition.LIKE)
    private String name;
    //年龄
    @TableField(condition = "%s&lt;#{%s}")
    private Integer age;
    //邮箱
    private String email;
    //直属上级id
    private Long managerId;
    //创建时间
    private LocalDateTime createTime;
    //备注 transient 标明变量 ，不参与
    //private transient String remark;



    /*private static String remark;

    public static String getRemark() {
        return remark;
    }

    public static void setRemark(String remark) {
        User.remark = remark;
    }*/

   /* @TableField(exist = false)
    private String remark;
*/
}
