package com.example.springbootmybatis03;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springbootmybatis03.mapper")
public class SpringBootMybatis03Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatis03Application.class, args);
    }

}
