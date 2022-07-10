package com.ww.mybatisplus_datasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ww.mybatisplus_datasource.mapper.ProductMapper;
import com.ww.mybatisplus_datasource.pojo.Product;
import com.ww.mybatisplus_datasource.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @Author: ww
 * @DateTime: 2022/7/10 14:01
 * @Description: This is description of class
 */
@Service
@DS("slave_1")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
