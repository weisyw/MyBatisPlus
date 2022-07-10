package com.ww;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @Author: ww
 * @DateTime: 2022/7/10 13:41
 * @Description: This is description of class
 */
public class FastAutoGeneratorTest {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/mybatis_plus?characterEncoding=utf-8&userSSL=false", "root", "root")
                        .globalConfig(builder -> {
                            // 设置作者
                            builder.author("ww")
                                    //.enableSwagger() // 开启 swagger 模式
                                    // 覆盖已生成文件
                                    .fileOverride()
                                    // 指定输出目录
                                    .outputDir("D://mybatis_plus");
                        })
                        .packageConfig(builder -> {
                            // 设置父包名
                            builder.parent("com.ww")
                                    // 设置父包模块名
                                    .moduleName("mybatisplus")
                                    // 设置mapperXml生成路径
                                    .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://mybatis_plus"));
                        })
                        .strategyConfig(builder -> {
                            // 设置需要生成的表名
                            builder.addInclude("t_user")
                                    // 设置过滤表前缀
                                    .addTablePrefix("t_", "c_");
                        })
                        // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                        .templateEngine(new FreemarkerTemplateEngine())
                        .execute();
    }
}
