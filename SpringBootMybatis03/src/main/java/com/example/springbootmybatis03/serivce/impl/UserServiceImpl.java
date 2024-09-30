package com.example.springbootmybatis03.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootmybatis03.bean.User;
import com.example.springbootmybatis03.mapper.UserMapper;
import com.example.springbootmybatis03.serivce.Userservice;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements Userservice {

}
