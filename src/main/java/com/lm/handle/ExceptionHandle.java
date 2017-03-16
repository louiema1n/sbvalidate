package com.lm.handle;

import com.lm.domain.Result;
import com.lm.exceptionm.UserException;
import com.lm.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 * Created by Louie on 2017-03-16.
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handle(Exception e) {

        // 判断e是否为自定义的UserException
        if (e instanceof UserException) {
            // 是，强转
            UserException userException = (UserException) e;
            return ResultUtil.error(userException.getCode(), userException.getMessage());
        }
        return ResultUtil.error(-1, "未知错误");
    }

}
