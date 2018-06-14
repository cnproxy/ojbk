package com.github.cnproxy.service;

import com.github.cnproxy.OJBKApplication;
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
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    @Rollback
    public void saveUser() throws Exception {

    }
}
