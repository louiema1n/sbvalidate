package com.lm.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by Louie on 2017-03-16.
 */
@Aspect
@Component  // 加入spring容器
public class HttpAspct {

    @Before(value = "execution(public * com.lm.controller.UserController.listAll(..))") // ..表示任意参数
    public void log() {
        System.out.println("AOP-before执行了");
    }

    @After(value = "execution(public * com.lm.controller.UserController.listAll(..))")
    public void doAfter() {
        System.out.println("AOP-after执行了");
    }
}
