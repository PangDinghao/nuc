package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 胖大海
 */
@MapperScan("com.example.demo.mapper")
@SpringBootApplication
public class MybatisPlusText01Application {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusText01Application.class, args);
    }

}
