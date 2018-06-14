package com.github.cnproxy.mapper;

import com.github.cnproxy.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void saveUser(final User user);

    User findUser(final String qq);
}
