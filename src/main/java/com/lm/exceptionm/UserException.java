package com.lm.exceptionm;

import com.lm.enums.ResultEnum;

/**
 * 自定义UserException
 * Created by Louie on 2017-03-16.
 */
public class UserException extends RuntimeException {

    public Integer code;

    public UserException(ResultEnum resultEnum) {
        // 将message传递给父类即可
        super(resultEnum.getMeaasge());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
