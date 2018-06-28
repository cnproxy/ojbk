package com.github.cnproxy.service.impl;

import com.github.cnproxy.entity.User;
import com.github.cnproxy.mapper.UserMapper;
import com.github.cnproxy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired UserMapper userMapper;

    @Override
    public void saveUser(User user) {
        if(StringUtils.isNotBlank(user.getPass())) {
            final String pass = DigestUtils.md5Hex(user.getPass());
            user.setPass(pass);
        }
        userMapper.saveUser(user);
    }

    @Override
    public User getUser(final String qq) {
        return userMapper.findUser(qq);
    }

    @Override
    public User login(String qq, String pass) {
        User user = userMapper.login(qq);
        if(null == user) {
            log.error("User doesn't exists");
            throw new RuntimeException("User doesn't exists");
        }
        if(!DigestUtils.md5Hex(pass).equals(user.getPass())){
            log.error("Password error");
            throw new RuntimeException("Password error");
        }
        return user;
    }
}
