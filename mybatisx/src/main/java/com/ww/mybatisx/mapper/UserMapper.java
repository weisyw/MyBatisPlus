package com.ww.mybatisx.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.ww.mybatisx.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 王为
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2022-07-10 17:31:37
* @Entity com.ww.mybatisx.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {

    int insertSelective(User user);

    int deleteByUidAndUsername(@Param("uid") Long uid, @Param("username") String username);

    int updateAgeByUid(@Param("age") Integer age, @Param("uid") Long uid);

    List<User> selectAllByUid(@Param("uid") Long uid);

}




