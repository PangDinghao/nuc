package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.bean.User;
import com.example.demo.mapper.UserMapper;

import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 53595
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    @Override
    public List<User> listByAge(int age) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>().eq(age > 0 && age < 200, "age", age);

        return list(wrapper);
    }
}
