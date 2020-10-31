package com.mp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mp.entity.User;
import com.mp.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void deleteById() {
        int rows = userMapper.deleteById(1274905377510567937l);
        System.out.println("影响记录数：" + rows);
    }
    @Test
    public void deleteByMap(){
        Map<String,Object> columnMap=new HashMap<String,Object>();
        columnMap.put("name","向西");
        columnMap.put("age",26);
        int rows=userMapper.deleteByMap(columnMap);
        System.out.println("删除记录数："+rows);

    }
    @Test
    public void deleteBatchIds(){
        int rows=userMapper.deleteBatchIds(Arrays.asList(1274682539994378241l,1274889962017316866l));
        System.out.println("删除记录数："+rows);
    }
    @Test
    public void deleteByWrapper(){
        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<User>();
        lambdaQueryWrapper.eq(User::getAge,19).or().gt(User::getAge,40);
        int rows=userMapper.delete(lambdaQueryWrapper);
        System.out.println("删除记录数："+rows);
    }

}
