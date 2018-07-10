package com.github.cnproxy.service.impl;

import com.github.cnproxy.dto.ExpiredRankingDTO;
import com.github.cnproxy.mapper.ProxyMapper;
import com.github.cnproxy.service.ProxyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProxyServiceImpl implements ProxyService {

    @Autowired private ProxyMapper proxyMapper;

    @Override
    public List<ExpiredRankingDTO> getExpiredRanking() {
        return proxyMapper.expiredRanking();
    }
}
