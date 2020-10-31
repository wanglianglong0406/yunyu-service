package com.mp;

import com.mp.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArTest {

    @Test
    public void insert() {
        User user = new User();
        user.setName("乾夫");
        user.setAge(26);
        user.setEmail("qianfu@qq.com");
        user.setManagerId(1274677851349651453L);
        user.setCreateTime(LocalDateTime.now());
        boolean insert=user.insert();
        System.out.println("影响记录数：" + insert);
        System.out.println("主键id：" + user.getUserId());
        System.out.println(user);
    }

    @Test
    public void selectById(){
        User user=new User();
        User userSelect=user.selectById(1274677851349651453L);
        System.out.println(user==userSelect);
        System.out.println(userSelect);
    }

    @Test
    public void selectById2(){
        User user=new User();
        user.setUserId(1274677851349651453L);
        User userSelect=user.selectById();
        System.out.println(user==userSelect);
        System.out.println(userSelect);
    }

    @Test
    public void updateById(){
        User user=new User();
        user.setUserId(1274677851349651453L);
        user.setName("六大能");
        user.setAge(25);
        user.setCreateTime(LocalDateTime.now());
        user.setEmail("liudaneng@qq.com");
        boolean updateById=user.updateById();
        System.out.println(updateById);

    }

    @Test
    public void deleteById(){
        User user=new User();
        user.setUserId(1274677851349651453L);

        boolean deleteById=user.deleteById();
        System.out.println(deleteById);
    }

    @Test
    public void insertOrUpdate() {
        User user = new User();
        user.setName("张强强");
        user.setAge(24);
        user.setUserId(1275593532373377025L);
        user.setEmail("zhangqiangqiang@qq.com");
        user.setManagerId(1274677851349651453L);
        user.setCreateTime(LocalDateTime.now());
        boolean insertOrUpdate=user.insertOrUpdate();
        System.out.println("影响记录数：" + insertOrUpdate);

    }

}
