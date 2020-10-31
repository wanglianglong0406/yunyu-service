package com.mp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.mp.entity.User;
import com.mp.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestList {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void select() {
        List list = userMapper.selectList(null);
        list.forEach(System.out::println);

    }
    @Test
    public void selectById() {
        User user = userMapper.selectById(1274677851349651452L);
        System.out.println(user);
    }

    //批量查询
    @Test
    public void selects() {
        List<Long> idList = Arrays.asList(1274677851349651452L, 1274680049806712834l, 1274680790201950210l);
        List<User> userLis = userMapper.selectBatchIds(idList);
        userLis.forEach(System.out::println);
    }

    @Test
    public void selectByMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        //key指向数据库中的列名
        //map.put("name","王开");
        map.put("age", "26");
        List<User> userList = userMapper.selectByMap(map);
        userList.forEach(System.out::println);
    }

    /**
     * 名字中包含王并且年龄小于40
     */
    @Test
    public void selectByWarp() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //QueryWrapper<User> queryWrapper1= Wrappers.<User>query();
        queryWrapper.like("name", "王").lt("age", "40");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

    }

    /**
     * 名字中包含王并且年龄大于等于20且小于等于40且emal不为空
     */
    @Test
    public void selectByWarp2() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //QueryWrapper<User> queryWrapper1= Wrappers.<User>query();
        queryWrapper.like("name", "王").between("age", 20, 40).isNotNull("email");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

    }

    /**
     * 名字王姓或者年龄大于等于25，按年龄降序，年龄相同按照id升序
     */
    @Test
    public void selectByWarp3() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //QueryWrapper<User> queryWrapper1= Wrappers.<User>query();
        queryWrapper.likeRight("name", "王").or().ge("age", 25).orderByDesc("age");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

    }

    /**
     * 创建日期为2020年6月21日并且直属上级名字为
     */
    @Test
    public void selectByWarp4() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.apply("date_format(create_time,'%Y-%m-%d')={0}", "2020-06-21")
                .inSql("manager_id", "select user_id from user where name like '王%'");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

    }

    /**
     * 名字为王姓且(年龄小于40 或邮箱不为空)
     */
    @Test
    public void selectByWarp5() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.likeRight("name", "王").and(wq -> wq.lt("age", 40).or().isNotNull("email"));
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

    }

    /**
     * 名字为王，或者（年龄小于40 并且年龄大于20并且邮箱不为空）
     */
    @Test
    public void selectByWarp6() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.likeRight("name", "王")
                .or(wq -> wq.lt("age", 40).gt("age", 20).isNotNull("email"));
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

    }

    /**
     * (年龄小于40或邮箱不为空) 并且名字为王姓
     */
    @Test
    public void selectByWarp7() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.nested(wq -> wq.lt("age", 40).or().isNotNull("email"))
                .likeRight("name", "王");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

    }


    /**
     * 年龄为30，31，34，35
     */
    @Test
    public void selectByWarp8() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.in("age", Arrays.asList(30, 31, 34, 35));
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

    }

    /**
     * 只返回满足条件的一条即可
     */
    @Test
    public void selectByWarp9() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.in("age", Arrays.asList(30, 31, 34, 35)).last("limit 1");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

    }

    /**
     * 查询指定的列明
     */
    @Test
    public void selectByWarpSuper() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //QueryWrapper<User> queryWrapper1= Wrappers.<User>query();
        queryWrapper.select("user_id", "name", "age").like("name", "王").lt("age", "40");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

    }

    /**
     * 排除不需要的字段查询剩余的所有
     */
    @Test
    public void selectByWarpSuper2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //QueryWrapper<User> queryWrapper1= Wrappers.<User>query();
        queryWrapper.like("name", "小").lt("age", 40)
                .select(User.class, info -> !info.getColumn().equals("create_time") &&
                        !info.getColumn().equals("manager_id"));
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void testCondition() {
        String name = "王";
        String email = "";
        condition(name, email);
    }
    @Test
    private void condition(String name, String email) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        /*if(StringUtils.isNotBlank(name)){
            queryWrapper.like("name",name);
        }
        if(StringUtils.isNotBlank(email)){
            queryWrapper.like("email",email);
        }*/

        queryWrapper.like(StringUtils.isNotEmpty(name), "name", name)
                .like(StringUtils.isNotEmpty(email), "email", email);
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void selectByWrapperEntity() {
        User whereUser = new User();
        whereUser.setName("小");
        whereUser.setAge(40);
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>(whereUser);
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

    }


    @Test
    public void selectBYWrapperAllEq() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "王开");
        map.put("age", null);
        //queryWrapper.allEq(map,false);

        queryWrapper.allEq((k, v) -> !k.equals("name"), map);
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void selectByWrapperMaps() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.select("user_id", "name").like("name", "王").lt("age", 40);
        List<Map<String, Object>> userList = userMapper.selectMaps(queryWrapper);
        userList.forEach(System.out::println);

    }

    /**
     * 按照直属上级分组，查询每组的平均年龄，最大年龄，最小年龄，并且只取年龄综合小于500 的组
     */
    @Test
    public void selectByWrapperMaps2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.select("avg(age) age", "min(age) min_age", "max(age) max_age")
                .groupBy("manager_id").having("sum(age)<{0}", 500);

        List<Map<String, Object>> userList = userMapper.selectMaps(queryWrapper);
        userList.forEach(System.out::println);

    }


    @Test
    public void selectByWrapperObjs() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.select("user_id", "name").like("name", "王").lt("age", 40);
        List<Object> userList = userMapper.selectObjs(queryWrapper);
        userList.forEach(System.out::println);

    }


    @Test
    public void selectByWrapperCount() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.like("name", "王").lt("age", 20);
        int count = userMapper.selectCount(queryWrapper);
        System.out.println("总记录数=" + count);
    }

    @Test
    public void selectByWrapperOne() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.like("name", "王").lt("age", 20);
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }

    @Test
    public void selectLambda() {
        LambdaQueryWrapper<User> lambda = new QueryWrapper<User>().lambda();
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>();

        LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User>lambdaQuery();
        lambdaQuery.like(User::getName, "王").lt(User::getAge, 40);
        List<User> userList = userMapper.selectList(lambdaQuery);
        userList.forEach(System.out::println);

    }

    @Test
    public void selectLambda2() {
        LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User>lambdaQuery();
        lambdaQuery.likeRight(User::getName, "王")
                .and(lqw -> lqw.lt(User::getAge, 40).or().isNotNull(User::getEmail));
        List<User> userList = userMapper.selectList(lambdaQuery);
        userList.forEach(System.out::println);

    }

    @Test
    public void selectLambda3() {
        List<User> userList = new LambdaQueryChainWrapper<User>(userMapper).like(User::getName, "王").ge(User::getAge, 20).list();
        userList.forEach(System.out::println);
    }


    @Test
    public void selectMy() {
        LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User>lambdaQuery();
        lambdaQuery.likeRight(User::getName, "王")
                .and(lqw -> lqw.lt(User::getAge, 20).or().isNotNull(User::getEmail));
        List<User> userList = userMapper.selectAll(lambdaQuery);
        userList.forEach(System.out::println);

    }


    @Test
    public void selectPage() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.ge("age", 26);
        Page<User> page = new Page<User>(1, 3, true);
        IPage<User> iPage = userMapper.selectPage(page, queryWrapper);
        System.out.println("总页数：" + iPage.getPages());
        System.out.println("总记录数：" + iPage.getTotal());

        List<User> userList = iPage.getRecords();
        userList.forEach(System.out::println);

    }

    @Test
    public void selectMapsPage() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.ge("age", 26);
        Page<User> page = new Page<User>(1, 2, true);
        IPage<Map<String, Object>> iPage = userMapper.selectMapsPage(page, queryWrapper);
        System.out.println("总页数：" + iPage.getPages());
        System.out.println("总记录数：" + iPage.getTotal());
        List<Map<String, Object>> userList = iPage.getRecords();
        userList.forEach(System.out::println);
    }

    @Test
    public void selectUserPage() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.ge("age", 26);
        Page<User> page = new Page<User>(1, 2, true);
        IPage<User> iPage = userMapper.selectUserPage(page, queryWrapper);
        System.out.println("总页数：" + iPage.getPages());
        System.out.println("总记录数：" + iPage.getTotal());
        List<User> userList = iPage.getRecords();
        userList.forEach(System.out::println);
    }

}


