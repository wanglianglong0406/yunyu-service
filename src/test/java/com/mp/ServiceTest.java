package com.mp;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mp.entity.User;
import com.mp.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void getOne() {
        User user = userService.getOne(Wrappers.<User>lambdaQuery().gt(User::getAge, 25), false);
        System.out.println(user);
    }

    @Test
    public void saveBatch() {
        User user1 = new User();
        user1.setName("徐丽4");
        user1.setUserId(1275594111933931528l);
        user1.setAge(30);
        user1.setEmail("xuli4@outlook.com");
        user1.setCreateTime(LocalDateTime.now());

        User user2 = new User();
        user2.setUserId(1275594111933931527l);
        user2.setName("徐丽3");
        user2.setAge(29);
        user2.setEmail("xuli3@outlook.com");
        user2.setCreateTime(LocalDateTime.now());
        List<User> userList = Arrays.asList(user1, user2);
        // boolean saveBatch=userService.saveBatch(userList);
        boolean saveBatch = userService.saveOrUpdateBatch(userList);
        System.out.println(userService);
    }
    @Test
    public void chain() {
        List<User> userList = userService.lambdaQuery().gt(User::getAge, 25).like(User::getName, "王").list();
        userList.forEach(System.out::println);
    }
    @Test
    public void chain1() {
        boolean update = userService.lambdaUpdate().eq(User::getAge, 24).set(User::getAge, 30).update();
        System.out.println(update);

    }
    @Test
    public void chain2() {
        boolean remove = userService.lambdaUpdate().eq(User::getAge, 23).remove();
        System.out.println(remove);
    }
}
