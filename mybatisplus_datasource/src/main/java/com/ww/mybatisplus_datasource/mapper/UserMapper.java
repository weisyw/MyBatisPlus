package com.ww.mybatisplus_datasource.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ww.mybatisplus_datasource.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: ww
 * @DateTime: 2022/7/10 14:08
 * @Description: This is description of class
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
