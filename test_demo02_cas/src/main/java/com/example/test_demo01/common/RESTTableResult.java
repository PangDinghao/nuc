package com.example.test_demo01.common;

import java.io.Serializable;
import java.util.List;

public class RESTTableResult<T> implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 总记录数 */
    private long total;

    /** 列表数据 */
    private List<T> data;

    /** 消息状态码 */
    private int code;

    /** 消息内容 */
    private String msg;

    /** 失败 */
    public static final int FAIL = 500;
    public static final int SUCCESS =200;

    /**
     * 表格数据对象
     */
    public RESTTableResult()
    {
    }

    /**
     * 分页
     *
     * @param list 列表数据
     * @param total 总记录数
     */
    public RESTTableResult(List<T> list, int total)
    {
        this.data = list;
        this.total = total;
    }

    public long getTotal()
    {
        return total;
    }

    public void setTotal(long total)
    {
        this.total = total;
    }

    public List<T> getData()
    {
        return data;
    }

    public void setData(List<T> data)
    {
        this.data = data;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public static <T> RESTTableResult<T> fail(String msg)
    {
        return restResult(null, FAIL, msg);
    }

    public static <T> RESTTableResult<T> fail(List<T> rows)
    {
        return restResult(rows, FAIL, "操作失败");
    }

    public static <T> RESTTableResult<T> fail(List<T> rows, String msg)
    {
        return restResult(rows, FAIL, msg);
    }

    public static <T> RESTTableResult<T> fail(int code, String msg)
    {
        return restResult(null, code, msg);
    }
    public static <T> RESTTableResult<T> success( String msg)
    {
        return restResult(null, SUCCESS, msg);
    }


    private static <T> RESTTableResult<T> restResult(List<T> rows, int code, String msg)
    {
        RESTTableResult<T> RESTTableResult = new RESTTableResult<>();
        RESTTableResult.setCode(code);
        RESTTableResult.setData(rows);
        RESTTableResult.setTotal(0);
        RESTTableResult.setMsg(msg);
        return RESTTableResult;
    }
}