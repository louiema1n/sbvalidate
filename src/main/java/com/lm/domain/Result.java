package com.lm.domain;

/**
 * 响应数据的最外层
 * Created by Louie on 2017-03-16.
 */
public class Result<T> {
    // 状态码：0-失败；1-成功
    private Integer code;

    // 信息
    private String msg;

    // 数据data
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
