package com.github.cnproxy.mapper;

import com.github.cnproxy.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User findUserByUsername(final String username);

    User findUserByUserId(final Integer userId);

    User getUser(final String username);

    void saveUser(final User user);

    void grantUserRole(final Integer userId);

    void updatePassword(@Param("username") final String username, @Param("password") final String password);

}
