package com.lm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Louie on 2017-03-16.
 */
@Aspect
@Component  // 加入spring容器
public class HttpAspct {

    /**
     * spring自带日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpAspct.class);

    // 切点
    @Pointcut(value = "execution(public * com.lm.controller.UserController.add(..))") // ..表示任意参数
    public void log() {
    }

    /**
     * 获取请求内容
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 请求url
        LOGGER.info("url={}", request.getRequestURL());
        // 请求method
        LOGGER.info("method={}", request.getMethod());
        // 请求ip
        LOGGER.info("ip={}", request.getRemoteAddr());
        // 请求class_method
        LOGGER.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + joinPoint.getSignature().getName());
        // 请求args
        LOGGER.info("args={}", joinPoint.getArgs());

        LOGGER.info("AOP-before执行了");
    }

    @After("log()")
    public void doAfter() {
        LOGGER.info("AOP-after执行了");
    }

    /**
     * 显示响应的内容
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        LOGGER.info("respose={}", object.toString());
    }
}
