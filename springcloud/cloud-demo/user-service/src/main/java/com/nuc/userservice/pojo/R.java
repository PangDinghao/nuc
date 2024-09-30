package com.nuc.userservice.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @author king
 * @date 2024/1/12 16:14
 * @desc 接口回写数据实体
 */
@Data
@ToString
public class R {

    private int code = 200;
    private String message;
    private Object data;

    public static R ok() {
        return new R();
    }

    public static R fail() {
        R r = new R();
        r.setCode(0);
        return r;
    }

    public R message(String message) {
        setMessage(message);
        return this;
    }

    public R data(Object data) {
        setData(data);
        return this;
    }

}