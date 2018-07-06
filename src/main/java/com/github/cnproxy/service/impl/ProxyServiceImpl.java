package com.github.cnproxy.service.impl;

import com.github.cnproxy.dto.ExpiredRankingDTO;
import com.github.cnproxy.entity.User;
import com.github.cnproxy.mapper.ProxyMapper;
import com.github.cnproxy.service.ProxyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProxyServiceImpl implements ProxyService {

    @Autowired private ProxyMapper proxyMapper;
    @Autowired private PasswordEncoder passwordEncoder;

    @Override
    public void register(final User user) {
        if(StringUtils.isNotBlank(user.getPass())) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            final String pass = user.getPass();
            user.setPass(encoder.encode(pass));
        }
        proxyMapper.saveUser(user);
        proxyMapper.grantUserRole(user.getId());
    }

    @Override
    public User getUser(final String qq) {
        return proxyMapper.findUser(qq);
    }

    @Override
    public User findUser(String qq) {
        User user = proxyMapper.findUserByQQ(qq);
        if(null == user) {
            log.error("User doesn't exists");
            throw new RuntimeException("User doesn't exists");
        }
        return user;
    }

    @Override
    public List<ExpiredRankingDTO> getExpiredRanking() {
        return proxyMapper.expiredRanking();
    }
}
