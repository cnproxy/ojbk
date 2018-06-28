package com.github.cnproxy.service.impl;

import com.github.cnproxy.dto.ExpiredRankingDTO;
import com.github.cnproxy.entity.User;
import com.github.cnproxy.mapper.ProxyMapper;
import com.github.cnproxy.service.ProxyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProxyServiceImpl implements ProxyService {

    @Autowired
    private ProxyMapper proxyMapper;

    @Override
    public void saveUser(User user) {
        if(StringUtils.isNotBlank(user.getPass())) {
            final String pass = DigestUtils.md5Hex(user.getPass());
            user.setPass(pass);
        }
        proxyMapper.saveUser(user);
    }

    @Override
    public User getUser(final String qq) {
        return proxyMapper.findUser(qq);
    }

    @Override
    public User login(String qq, String pass) {
        User user = proxyMapper.login(qq);
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

    @Override
    public List<ExpiredRankingDTO> getExpiredRanking() {
        return proxyMapper.expiredRanking();
    }
}
