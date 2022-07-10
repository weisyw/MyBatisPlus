package com.ww.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ww.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: ww
 * @DateTime: 2022/7/10 11:55
 * @Description: This is description of class
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}
