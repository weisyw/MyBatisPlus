package com.ww.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ww.mapper.UserMapper;
import com.ww.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @Author: ww
 * @DateTime: 2022/7/9 19:53
 * @Description: This is description of class
 */
@Service
public class UserSericeImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
