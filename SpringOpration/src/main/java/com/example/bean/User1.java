package com.example.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@TableName("user1")
@Data
public class User1 {

    @TableId(type = IdType.AUTO)
    private int id;
    private String account;
    private String password;
    private int age;
    private  String phone;
    @TableLogic
    private int deleted;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
