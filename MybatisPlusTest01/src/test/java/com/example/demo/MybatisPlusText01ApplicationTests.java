package com.example.demo;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.example.demo.bean.User;
import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusText01ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserMapper userMapper;
    Logger logger = LoggerFactory.getLogger(this.getClass());


    /*
    测试 MybatisPlus 的 查询
     */
    @Test
    void testSelect1() {
        User user = userMapper.selectById(2);
        logger.info(user.toString());
    }

    @Test
    void testSelect2() {
        List<User> users = userMapper.selectList(null);
        users.forEach(user -> logger.info(user.toString()));

        Assert.isTrue(users.size() == 5, "结果数据总量不对");
    }

    @Test
    void testInsert(){
        User user = new User();
        user.setName("zs");
        user.setAge(11);
        user.setEmail("123123");

        int line = userMapper.insert(user);

        if (line>0){
            logger.info("新增成功");
        }else {
            logger.error("新增失败");
        }
    }

    @Test
    void testDelete(){
        userMapper.deleteById(8);
    }

    @Test
    void testUpdate(){
        User user = userMapper.selectById(2);
        user.setName("zs");

        int i = userMapper.updateById(user);
        if (i>0){
            logger.info("修改成功");
        }else {
            logger.error("修改失败");
        }
    }

}
