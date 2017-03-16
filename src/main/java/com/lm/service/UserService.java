package com.lm.service;

import com.lm.domain.User;
import com.lm.enums.ResultEnum;
import com.lm.exceptionm.UserException;
import com.lm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 业务层
 * Created by Louie on 2017-03-16.
 */
@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 获取用户年龄
     * @param id
     * @return
     * @throws Exception
     */
    public void getAge(Integer id) throws Exception{
        User user = userRepository.findOne(id);
        if (user.getAge() < 10 || user.getAge() == 10) {
            throw new UserException(ResultEnum.PRIMARY_SCHOOL);
        } else if (user.getAge() > 10 && user.getAge() < 16) {
            throw new UserException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    public User findUserById(Integer id) {
        return this.userRepository.findOne(id);
    }
}
