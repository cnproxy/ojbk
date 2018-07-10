package com.github.cnproxy.mapper;

import com.github.cnproxy.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User findUserByUsername(final String username);

    User findUserByUserId(final Integer userId);

    User getUser(final String username);

    void saveUser(final User user);

    void grantUserRole(final Integer userId);


}
