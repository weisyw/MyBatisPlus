package com.ww;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ww.mapper.UserMapper;
import com.ww.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @Author: ww
 * @DateTime: 2022/7/9 22:05
 * @Description: This is description of class
 */

@SpringBootTest
public class MyBatisPlusWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){
        //查询用户名包含a，年龄在20到30之间，并且邮箱不为null的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username", "a")
                .between("age", 20, 30)
                .isNotNull("email");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void test02(){
        // 查询用户信息，按照年龄的降序排序，若年龄相同，则按id升序排序
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age").orderByAsc("uid");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void test03(){
        // 删除邮箱地址为空的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int rows = userMapper.delete(queryWrapper);
        System.out.println("rows:" + rows);
    }

    @Test
    public void test04(){
        // 将（年龄大于20并且用户名中包含有a）或邮箱为null的用户信息修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age", 20)
                .like("username", "a")
                .or().isNull("email");
        User user = new User();
        user.setAge(10);
        user.setEmail("2222@qq.com");
        int rows = userMapper.update(user, queryWrapper);
        System.out.println(rows);
    }

    @Test
    public void test05(){
        // 将用户名中包含a并且（年龄大于20或邮箱为null）的用户信息修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username", "a")
                .and(i->i.gt("age", 20).or().isNull("email"));
        User user = new User();
        user.setAge(10);
        user.setEmail("2222@qq.com");
        int rows = userMapper.update(user, queryWrapper);
        System.out.println(rows);
    }

    @Test
    public void test06(){
        // 查询用户名、年龄、邮箱信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("username", "age", "email");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(map -> System.out.println(map));
    }

    @Test
    public void test07(){
        // 查询id小于等于100的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("uid","select uid from t_user where uid <= 100");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void test08(){
        // // 将用户名中包含a并且（年龄大于20或邮箱为null）的用户信息修改
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.like("username", "a")
                .and(i -> i.gt("age", 20).or().isNull("email"));
        updateWrapper.set("username", "小明").set("email","xm@qq.com");
        int rows = userMapper.update(null, updateWrapper);
        System.out.println("rows:" + rows);
    }

    @Test
    public void test09(){
        //定义查询条件，有可能为null（用户未输入或未选择）
        String username = "";
        Integer ageBegin = 10;
        Integer ageEnd = 20;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(username)){
            queryWrapper.like("username","a");
        }
        if(ageBegin != null){
            queryWrapper.ge("age", ageBegin);
        }
        if(ageEnd != null){
            queryWrapper.le("age", ageEnd);
        }
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void test10(){
        String username = "";
        Integer ageBegin = 10;
        Integer ageEnd = 20;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username), "username", username)
                .ge(ageBegin != null, "age", ageBegin)
                .le(ageBegin != null, "age", ageEnd);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void test11(){
        String username = "";
        Integer ageBegin = 10;
        Integer ageEnd = 20;
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.isNotBlank(username), User::getName, username)
                .ge(ageBegin != null, User::getAge, ageBegin)
                .le(ageBegin != null, User::getAge, ageEnd);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void test12(){
        // // 将用户名中包含a并且（年龄大于20或邮箱为null）的用户信息修改
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.like(User::getName, "a")
                .and(i -> i.gt(User::getAge, 20).or().isNull(User::getEmail));
        lambdaUpdateWrapper.set(User::getName, "小明").set(User::getEmail,"xm@qq.com");
        int rows = userMapper.update(null, lambdaUpdateWrapper);
        System.out.println("rows:" + rows);
    }

}
