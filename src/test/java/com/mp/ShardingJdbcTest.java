package com.mp;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mp.bo.OrderBO;
import com.mp.dao.OrderMapper;
import com.mp.entity.Area;
import com.mp.entity.Order;
import com.mp.entity.OrderItem;
import com.mp.service.AreaService;
import com.mp.service.OrderCustomService;
import com.mp.service.OrderItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingJdbcTest {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private AreaService areaService;

    @Resource
    private OrderItemService orderItemService;
    @Resource
    private OrderCustomService orderCustomService;
    @Test
    public void add() {
        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setPrice(BigDecimal.valueOf(700));
            order.setStatus("0");

            orderMapper.insert(order);
        }
    }

    @Test
    public void find() {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        List<Long> list = new ArrayList<>();
        list.add(418766159777628160L); //库1的t_order_2中
        list.add(418766159765045249L);  //库2的t_order_1中
        queryWrapper.in("user_id",list);
        orderMapper.selectList(queryWrapper);
    }
    @Test
    public void testGlobal(){
        Area area =new Area();
        area.setId(3);
        area.setName("广州");
        boolean save = areaService.save(area);
        System.err.println("受影响结果："+save);
    }

    @Test
    public void testFindGlobal(){

        Area area = areaService.getById(3);
        System.err.println("受影响结果："+area.toString());
    }

    @Test
    public void testOrderItem(){
        OrderItem orderItem=new OrderItem();
        //orderItem.setId(1l);
        orderItem.setNum(1);
        orderItem.setOrderId(1320264024483815425l);
        orderItem.setUserId(527143681027735552l);
        orderItem.setProduceName("测试商品3");
        boolean save = orderItemService.save(orderItem);
        System.err.println("受影响结果："+save);
    }

    /**
     * 联表查询
     */
    @Test
    public void testFindOrderDetail(){
        List<OrderBO> orderList = orderCustomService.getOrderInfos(1320264024483815425l);
        orderList.forEach(System.err::println);
    }


}
