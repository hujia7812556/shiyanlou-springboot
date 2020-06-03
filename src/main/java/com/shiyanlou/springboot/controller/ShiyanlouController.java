package com.shiyanlou.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@RestController
// RestController 相当于同时使用 @Controller 和 @ResponseBody 注解
// 加载 classpath 目录下的 shiyanlou.properties 文件
@PropertySource(value = "classpath:shiyanlou.properties")
public class ShiyanlouController{
    // 使用 @Value 注解注入属性值
    @Value("${shiyanlou.test}")
    private String shiyanlou;

    @RequestMapping("shiyanlou")
    public String shiyanlou(){
        return this.shiyanlou;
    }
}