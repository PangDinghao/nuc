package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//service CRUD测试
@SpringBootTest
public class ServiecTest {
    @Autowired
    private UserService userService;
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    void testService(){
        logger.info(userService.toString());
    }

    @Test
    void testSave(){
        User user = new User();
        user.setName("lisi");
        user.setAge(42);
        user.setEmail("lisi@sina.com");

        boolean flag = userService.save(user);
        if (flag) {
            logger.info("新增成功");
        } else {
            logger.error("新增失败");
        }


    }

    @Test
    void testRemove(){
        boolean flag = userService.removeById(5);
        if (flag) {
            logger.info("删除成");
        } else {
            logger.error("删除失败");
        }

    }

    @Test
    void testUpdate(){
        User user = userService.getById(2);
        user.setName("aaaa");

        boolean flag = userService.updateById(user);
        if (flag) {
            logger.info("修改成功");
        } else {
            logger.error("修改失败");
        }

    }

    @Test
    void testGet(){
        User user = userService.getById(3);
        logger.info(user.toString());
    }

    @Test
    void testList(){
        List<User> users = userService.list();
        logger.info(users.toString());
    }

    @Test
    void testPage(){
        Page<User> page = Page.of(2, 3);// limit 3,3
        Page<User> datas = userService.page(page);
        logger.info(datas.toString());

        /*
        * 物理分页：
        * select....limit 偏移量 取得数量
        * 第一页 select...lisit 0,3
        * 第二页 select...lisit 3,3
        * 第三页 select...lisit 6,3
        * */
    }

    @Test
    void testWrapper1(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("age",21);//age=? <-21
//        condition表示条件是否加入最后生成的sql
        queryWrapper.eq(1<2,"age",21);

        List<User> users= userService.list(queryWrapper);
        users.forEach(user -> logger.info(user.toString()));
    }

    @Test
    void testWrapper2() {
        List<User> users = userService.listByAge(21);
        users.forEach(user -> logger.info(user.toString()));
    }

    @Test
    void testtestWrapper3(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.ne("name","zs")
                .gt("age",20)
                .ge("id",3);


        List<User> users = userService.list(wrapper);
        users.forEach(user -> logger.info(user.toString()));

    }

    @Test
    void testtestWrapper4(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age",20,40)
                .like("name","a");


        List<User> users = userService.list(wrapper);
        users.forEach(user -> logger.info(user.toString()));
    }

    @Test
    void testtestWrapper5(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age",20,40)
                .gt("id",3)
                .or()
                .like("name","a")
                .gt("age",30);


        List<User> users = userService.list(wrapper);
        users.forEach(user -> logger.info(user.toString()));

    }

    @Test
    void testtestWrapper6(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age",20,40)
                .gt("id",3)
                .and(w->w.like("name","a"))
                .gt("age",30);


        List<User> users = userService.list(wrapper);
        users.forEach(user -> logger.info(user.toString()));

    }

    @Test
    void testWrapper7() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age", 20, 40)
                .gt("id", 3)
                .or()
                .like("name", "a")
                .gt("age", 30);
        wrapper.select("id", "name", "age");


        List<User> users = userService.list(wrapper);
        users.forEach(user -> logger.info(user.toString()));
    }

}
