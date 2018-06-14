package com.github.cnproxy.service.impl;

import com.github.cnproxy.entity.User;
import com.github.cnproxy.mapper.UserMapper;
import com.github.cnproxy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired UserMapper userMapper;

    @Override
    public void saveUser(final User user) {
        userMapper.saveUser(user);
    }

    @Override
    public User getUser(final String qq) {
        return userMapper.findUser(qq);
    }
}
