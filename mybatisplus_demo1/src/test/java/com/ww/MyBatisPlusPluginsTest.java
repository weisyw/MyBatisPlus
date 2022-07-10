package com.ww;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ww.mapper.ProductMapper;
import com.ww.mapper.UserMapper;
import com.ww.pojo.Product;
import com.ww.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: ww
 * @DateTime: 2022/7/10 11:28
 * @Description: This is description of class
 */

@SpringBootTest
public class MyBatisPlusPluginsTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void testPage(){
        //设置分页参数
        Page<User> page = new Page<>(1, 3);
        userMapper.selectPage(page, null);
        //获取分页数据
        List<User> list = page.getRecords();
        for (User user : list) {
            System.out.println(user);
        }
        System.out.println("当前页：" + page.getCurrent());
        System.out.println("每页显示的条数：" + page.getSize());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        System.out.println("是否有上一页：" + page.hasPrevious());
        System.out.println("是否有下一页：" + page.hasNext());
    }


    @Test
    public void testProduct01(){
        // 小李查询商品价格
        Product productLi = productMapper.selectById(1);
        System.out.println("小李查询的商品价格为：" + productLi.getPrice());
        // 小王查询商品价格
        Product productWang = productMapper.selectById(1);
        System.out.println("小王查询的商品价格为：" + productWang.getPrice());

        // 小李将价格加50
        productLi.setPrice(productLi.getPrice() + 50);
        productMapper.updateById(productLi);
        // 小王将价格减30
        productWang.setPrice(productWang.getPrice() - 30);
        int rows = productMapper.updateById(productWang);
        if (rows == 0) {
            // 操作失败，重试
            Product productNew = productMapper.selectById(1);
            productNew.setPrice(productNew.getPrice() - 30);
            productMapper.updateById(productNew);
        }

        // 老板查询商品价格
        Product productBoss = productMapper.selectById(1);
        System.out.println("老板查询的商品价格为：" + productBoss.getPrice());
    }
}
