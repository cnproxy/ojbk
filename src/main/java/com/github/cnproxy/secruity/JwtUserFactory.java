package com.github.cnproxy.secruity;

import com.github.cnproxy.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return create(user.getId(),user.getUsername(),user.getPass(),mapToGrantedAuthorities(user.getRoles()),true);
    }

    public static JwtUser create(final Integer userId, final String username,final String password, List<GrantedAuthority> authorities,final boolean enabled) {
        return new JwtUser(userId,username,password,authorities,enabled);
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }
}

