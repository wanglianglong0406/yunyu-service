package com.mp;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.LambdaUpdateChainWrapper;
import com.mp.entity.User;
import com.mp.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdateTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void updateById() {
        User user = new User();
        user.setUserId(1274678426069921793l);
        user.setAge(20);
        user.setEmail("wanglianglong@outlook.com");
        user.setCreateTime(LocalDateTime.now());
        int rows = userMapper.updateById(user);
        System.out.println("影响记录数：" + rows);
    }

    @Test
    public void updateByWrapper() {
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<User>();
        userUpdateWrapper.eq("name", "王开").eq("age", 26);
        User user = new User();
        user.setEmail("wk@outlook.com");
        user.setAge(27);
        user.setCreateTime(LocalDateTime.now());
        userMapper.update(user, userUpdateWrapper);

    }

    @Test
    public void updateByWrapper2() {
        User whereUser = new User();
        whereUser.setName("王开");
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<User>(whereUser);
        userUpdateWrapper.eq("name", "王开").eq("age", 26);
        User user = new User();
        user.setEmail("wk@outlook.com");
        user.setAge(27);
        user.setCreateTime(LocalDateTime.now());
        userMapper.update(user, userUpdateWrapper);

    }

    @Test
    public void updateByWrapper3() {
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<User>();
        userUpdateWrapper.eq("name", "王开").eq("age", 30)
                .set("age",30).set("create_time",LocalDateTime.now());

        userMapper.update(null, userUpdateWrapper);

    }

    @Test
    public void updateByLambda() {
        LambdaUpdateWrapper<User> lambdaUpdateWrapper=Wrappers.<User>lambdaUpdate();

        lambdaUpdateWrapper.eq(User::getName,"王开").eq(User::getAge,31).set(User::getAge,32)
                .set(User::getCreateTime,LocalDateTime.now());

        userMapper.update(null, lambdaUpdateWrapper);

    }

    @Test
    public void updateByLambdaChin() {

        boolean update=new LambdaUpdateChainWrapper<User>(userMapper)
                .eq(User::getName, "王开")
                .eq(User::getAge, 31).set(User::getAge,32).set(User::getCreateTime,LocalDateTime.now()).update();

        System.out.println(update);

    }
}
