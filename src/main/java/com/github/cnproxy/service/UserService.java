package com.github.cnproxy.service;

import com.github.cnproxy.entity.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {

    @Transactional(propagation = Propagation.REQUIRED)
    void saveUser(User user);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    User getUser(final String qq);
}
