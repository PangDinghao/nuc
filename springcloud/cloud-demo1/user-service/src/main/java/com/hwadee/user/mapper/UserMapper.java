package com.hwadee.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwadee.user.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {

    @Select("select * from tb_user where id = #{id}")
    User findById(@Param("id") Long id);
}