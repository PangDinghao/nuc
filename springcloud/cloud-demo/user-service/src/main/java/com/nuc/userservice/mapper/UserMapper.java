package com.nuc.userservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nuc.userservice.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {
    
    @Select("select * from tb_user where id = #{id}")
    User findById(@Param("id") Long id);
}