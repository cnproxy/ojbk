package com.github.cnproxy.service;

import com.github.cnproxy.OJBKApplication;
import com.github.cnproxy.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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
        User user = new User().setUsername("10001").setPassword("pony").setCreationOn(new Date()).setCreationOn(new Date());
        userService.register(user);
    }
}
