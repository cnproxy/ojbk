package com.github.cnproxy.service;

import com.github.cnproxy.entity.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    String loginAndGenerateToken(final String username, final String password);

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    User findUserById(final Integer userId);

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    User findUserByUsername(final String username);

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    User getUser(final String username);

    /**
     * 用户注册
     * @param user
     */
    @Transactional(propagation = Propagation.REQUIRED)
    void register(final User user);


}