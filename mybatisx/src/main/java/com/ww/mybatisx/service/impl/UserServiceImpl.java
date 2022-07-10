package com.ww.mybatisx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ww.mybatisx.pojo.User;
import com.ww.mybatisx.service.UserService;
import com.ww.mybatisx.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 王为
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-07-10 17:31:37
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




