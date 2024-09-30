package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bean.User1;
import org.apache.ibatis.annotations.Mapper;

//表user的数据库操作
@Mapper
public interface UserMapper extends BaseMapper<User1> {

}
