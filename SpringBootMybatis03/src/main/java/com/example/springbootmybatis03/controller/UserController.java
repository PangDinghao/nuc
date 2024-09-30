package com.example.springbootmybatis03.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootmybatis03.bean.User;
import com.example.springbootmybatis03.serivce.Userservice;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author king
 * @date 2024/1/12 11:28
 * @desc 用户接口管理
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private Userservice userService;

    Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 根据参数获取用户分页信息
     *
     * @param current
     * @param size
     * @return
     */
    @GetMapping("/page")
    public List<User> page(@RequestParam(required = false, defaultValue = "0") int current,
                           @RequestParam(required = false, defaultValue = "2") int size) {
        Page<User> page = userService.page(new Page<User>(current, size));

        logger.info("分页查询" + page);

        log.error("用户分页信息" + page.getRecords());

        return page.getRecords();
    }
}
