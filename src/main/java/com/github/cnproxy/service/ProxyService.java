package com.github.cnproxy.service;

import com.github.cnproxy.dto.ExpiredRankingDTO;
import com.github.cnproxy.entity.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ProxyService {

    @Transactional(propagation = Propagation.REQUIRED)
    void register(final User user);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    User getUser(final String qq);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    User findUser(final String qq);

    /**
     * 过期排行榜
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    List<ExpiredRankingDTO> getExpiredRanking();

}
