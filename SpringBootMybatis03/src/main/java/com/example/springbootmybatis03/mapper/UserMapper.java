package com.example.springbootmybatis03.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootmybatis03.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
