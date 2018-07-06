package com.github.cnproxy.secruity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@JsonIgnoreProperties({"id","password","accountNonExpired","accountNonLocked","credentialsNonExpired","enabled"})
public class JwtUser implements UserDetails {

    private static final long serialVersionUID = 5612953323982843239L;

    private final Integer id;
    private final String username;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;
    private final boolean enabled;

    public JwtUser(
            Integer id,
            String username,
            String password,
            Collection<? extends GrantedAuthority> authorities,
            boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.enabled = enabled;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
