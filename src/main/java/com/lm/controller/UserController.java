package com.lm.controller;

import com.lm.domain.Result;
import com.lm.domain.User;
import com.lm.repository.UserRepository;
import com.lm.service.UserService;
import com.lm.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Louie on 2017-03-16.
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {

    // 日志
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    /**
     * 新增用户,验证age>18的限制
     * @param user
     * @return
     */
    @PostMapping(value = "")
    public Result<User> add(@Valid User user, BindingResult bindingResult) {
        // 验证不通过，输出错误message信息
        if (bindingResult.hasErrors()) {
            return null;
//            return ResultUtil.error(0, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(userRepository.save(user));
    }

    /**
     * 显示所有用户数据
     * @return
     */
    @GetMapping(value = "")
    public List<User> listAll() {
        LOGGER.info("listAll执行了");
        return userRepository.findAll();
    }

    @GetMapping(value = "/getAge/{id}")
    public void getAge(@PathVariable Integer id) throws Exception{
        this.userService.getAge(id);
    }
}
