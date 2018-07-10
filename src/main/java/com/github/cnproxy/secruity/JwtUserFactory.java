package com.github.cnproxy.secruity;

import com.github.cnproxy.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return create(user.getId(),user.getUsername(),user.getPassword(),mapToGrantedAuthorities(user.getRoles()),user.isEnabled());
    }

    public static JwtUser create(final Integer userId, final String username, final String password, Collection<? extends GrantedAuthority> authorities, final boolean enabled) {
        return new JwtUser(userId,username,password,authorities,enabled);
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority))
                .collect(Collectors.toList());
    }
}

