package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.bean.User;

import java.util.List;

public interface UserService extends IService<User> {
    public List<User> listByAge(int age);
}