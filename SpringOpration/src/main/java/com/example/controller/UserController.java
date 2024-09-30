package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bean.R;
import com.example.bean.User1;
import com.example.serivce.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 53595
 */ //数据接口
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //@PostMapping("/register")
    @RequestMapping("/register")
    public R register(User1 user){

        //考虑用户名为空的情况
        if (
                !StringUtils.hasLength(user.getAccount())||
                !StringUtils.hasLength(user.getPassword())){
            return R.fail().message("用户名和密码不能为空");
        }

        //考虑用户名已存在的情况
        User1 getOneByAccount = userService.getOne(
                new QueryWrapper<User1>()
                        .eq("account", user.getAccount()));

        if(getOneByAccount!=null){
            //注册失败
            return R.fail().message("用户名已存在");
        }else {
            boolean flag = userService.save(user);
            if (flag){
                //注册成功
                return R.ok();
            }else {
                //注册失败
                return R.fail().message("用户注册失败");
            }
        }




    }

    @RequestMapping("/login")
    public  R login(User1 user,HttpSession httpSession){
        if( !StringUtils.hasLength(user.getAccount())||
                !StringUtils.hasLength(user.getPassword())){
            return R.fail().message("用户名和密码不能为空");
        }


        User1 getOneByAccountAndPassword = userService.getOne(
                new QueryWrapper<User1>()
                        .eq("account", user.getAccount())
                        .eq("password",user.getPassword())
        );

        if(getOneByAccountAndPassword!=null){

            //登陆成功
            httpSession.setAttribute("user",getOneByAccountAndPassword);
            return R.ok().data(getOneByAccountAndPassword);
        }else {

                return R.fail().message("用户或密码名错误");
            }
        }
    @RequestMapping("/logout")
    public R logou(HttpSession session){
        session.invalidate();
        return R.ok();
    }

    @RequestMapping("/info1")
    public R info1(HttpSession session){
        User1 user = (User1)session.getAttribute("user");
        return R.ok().data(user);
    }

    @RequestMapping("/info2")
    public R info2(int id){
        User1 user = userService.getById(id);
        return R.ok().data(user);
    }




}
