package com.lm.utils;

import com.lm.domain.Result;

/**
 * Created by Louie on 2017-03-16.
 */
public class ResultUtil {

    /**
     * 成功
     * @param object
     * @return
     */
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(1);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    /**
     * 成功
     * @return
     */
    public static Result success() {
        return success(null);
    }

    /**
     * 失败
     * @param code
     * @param msg
     * @return
     */
    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
}
