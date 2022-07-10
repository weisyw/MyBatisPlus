package com.ww;

import com.ww.enums.SexEnum;
import com.ww.mapper.UserMapper;
import com.ww.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: ww
 * @DateTime: 2022/7/10 13:28
 * @Description: This is description of class
 */

@SpringBootTest
public class MyBatisPlusEnumTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        User user = new User();
        user.setName("张三");
        user.setAge(55);
        user.setSex(SexEnum.MALE);
        int rows = userMapper.insert(user);
        System.out.println("rows:" + rows);
    }
}
