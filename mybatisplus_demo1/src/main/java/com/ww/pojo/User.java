package com.ww.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.ww.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ww
 * @DateTime: 2022/7/9 16:23
 * @Description: This is description of class
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//@TableName("t_user")
public class User {
    @TableId(value = "uid")
    private Long id;
    @TableField("username")
    private String name;
    private Integer age;
    private String email;
    @TableLogic
    private Integer isDelete;
    private SexEnum sex;
}
