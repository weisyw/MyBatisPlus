package com.ww.mybatisplus_datasource.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: ww
 * @DateTime: 2022/7/10 14:03
 * @Description: This is description of class
 */
@Data
@TableName("t_user")
public class User {
    @TableId
    private Integer uid;
    private String username;
    private Integer age;
    private String email;
    private Integer isDelete;
    private Integer sex;
}
