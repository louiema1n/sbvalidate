package com.lm.controller;

import com.lm.domain.User;
import com.lm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Louie on 2017-03-16.
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 新增用户,验证age>18的限制
     * @param user
     * @return
     */
    @PostMapping(value = "")
    public User add(@Valid User user, BindingResult bindingResult) {
        // 验证不通过，输出错误message信息
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return userRepository.save(user);
    }

    /**
     * 显示所有用户数据
     * @return
     */
    @GetMapping(value = "")
    public List<User> listAll() {
        System.out.println("listAll执行了");
        return userRepository.findAll();
    }
}
