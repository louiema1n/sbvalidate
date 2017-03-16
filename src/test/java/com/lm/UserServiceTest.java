package com.lm;

import com.lm.domain.User;
import com.lm.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Louie on 2017-03-16.
 */
@RunWith(SpringRunner.class)    // 使用junit测试
@SpringBootTest                 // 启动springboot启动程序
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findUserByIdTest() {
        User user = this.userService.findUserById(6);
        Assert.assertEquals(new Integer(9), user.getAge());
    }
}
