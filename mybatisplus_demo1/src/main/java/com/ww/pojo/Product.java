package com.ww.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @Author: ww
 * @DateTime: 2022/7/10 11:54
 * @Description: This is description of class
 */
@Data
public class Product {
    private Long id;
    private String name;
    private Integer price;
    @Version // 标识乐观锁版本号字段
    private Integer version;
}

