package com.ww.mybatisplus_datasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ww.mybatisplus_datasource.mapper.UserMapper;
import com.ww.mybatisplus_datasource.pojo.User;
import com.ww.mybatisplus_datasource.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author: ww
 * @DateTime: 2022/7/10 14:01
 * @Description: This is description of class
 */

@Service
@DS("master") //指定所操作的数据源
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
