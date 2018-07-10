package com.github.cnproxy.service;

import com.github.cnproxy.dto.ExpiredRankingDTO;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ProxyService {
    /**
     * 过期排行榜
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    List<ExpiredRankingDTO> getExpiredRanking();

}
