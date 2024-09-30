package com.example.springboottest001.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    //访问当前项目的路径 /index 时，会写一条字符串数据 hello world
    @RequestMapping("/index")
    public String index(){
        return "hello world!";
    }
}
