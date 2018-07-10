package com.github.cnproxy.service.impl;

import com.github.cnproxy.entity.User;
import com.github.cnproxy.mapper.UserMapper;
import com.github.cnproxy.secruity.JwtTokenUtil;
import com.github.cnproxy.secruity.JwtUser;
import com.github.cnproxy.secruity.JwtUserFactory;
import com.github.cnproxy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * @author cnproxy
 */

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private final static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public String loginAndGenerateToken(final String username, final String password) {
        User user = findUserByUsername(username);
        if(null != user) {
            if (encoder.matches(password,user.getPassword())) {
                final Integer userId = user.getId();
                user = findUserById(userId);
                return generateToken(user);
            }
        }
        return null;
    }

    @Override
    public User findUserById(Integer userId) {
        return userMapper.findUserByUserId(userId);
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public User getUser(final String username) {
        return userMapper.getUser(username);
    }

    /**
     * 产生 token
     * @param user
     * @return
     */
    private String generateToken(final User user) {
        JwtUser jwtUser = JwtUserFactory.create(
                user.getId(),user.getUsername(),user.getPassword(),
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList()),
                user.isEnabled());
        return jwtTokenUtil.generateToken(jwtUser);
    }


    @Override
    public void register(final User user) {
        final String bcryptPassword = encoder.encode(user.getPassword());
        log.info("User {} password is {}", user.getUsername(), bcryptPassword);
        user.setPassword(bcryptPassword);
        userMapper.saveUser(user);
        userMapper.grantUserRole(user.getId());
    }
}
