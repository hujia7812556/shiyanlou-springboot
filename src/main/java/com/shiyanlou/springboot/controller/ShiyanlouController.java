package com.shiyanlou.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShiyanlouController{

    @Value("77777")
    private String hello;


    @RequestMapping("shiyanlou")
    public String shiyanlou(){
        return hello;
    }
}