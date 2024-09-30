package com.example.bean;

import lombok.Data;
import lombok.ToString;

/**
 * @author 53595
 *
 * 接口会写数据实体
 */
@Data
@ToString
public class R {

    private int code = 200;
    private String message;
    private Object data;

    public static R ok(){
        return new R();
    }

    public static R fail(){
        R r = new R();
        r.setCode(0);
        return r;
    }

    public R message(String message){
        setMessage(message);
        return this;
    }

    public R data(Object data){
        setData(data);
        return this;
    }



}
