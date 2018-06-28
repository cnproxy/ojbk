package com.github.cnproxy.service;

import com.github.cnproxy.dto.ExpiredRankingDTO;
import com.github.cnproxy.entity.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ProxyService {

    @Transactional(propagation = Propagation.REQUIRED)
    void saveUser(User user);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    User getUser(final String qq);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    User login(final String qq,final String pass);

    /**
     * 过期排行榜
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    List<ExpiredRankingDTO> getExpiredRanking();

}
