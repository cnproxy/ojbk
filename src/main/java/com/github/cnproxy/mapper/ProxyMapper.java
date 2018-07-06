package com.github.cnproxy.mapper;

import com.github.cnproxy.dto.ExpiredRankingDTO;
import com.github.cnproxy.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProxyMapper {

    void saveUser(final User user);

    User findUser(final String qq);

    User findUserByQQ(final String qq);

    List<ExpiredRankingDTO> expiredRanking();

    void grantUserRole(final Integer userId);
}
