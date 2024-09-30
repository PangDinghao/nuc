package com.example.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bean.User1;
import com.example.mapper.UserMapper;
import com.example.serivce.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User1>
        implements UserService {
}
