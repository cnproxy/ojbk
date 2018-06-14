package com.github.cnproxy.service;

import com.github.cnproxy.OJBKApplication;
import com.github.cnproxy.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = OJBKApplication.class)
@Transactional
@Slf4j
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    @Rollback
    public void saveUser() throws Exception {
        User user = new User();
        user.setQq("10001");
        user.setPass("pony");
        userService.saveUser(user);
        User user2 = userService.getUser(user.getQq());
        log.info("User {} is: ", user.getQq(), user2.toString());
        Assert.assertEquals(user.getEmail(), user2.getEmail());
    }
}
