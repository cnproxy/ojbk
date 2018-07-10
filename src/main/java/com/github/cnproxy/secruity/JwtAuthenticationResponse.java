package com.github.cnproxy.secruity;

import lombok.Data;

import java.io.Serializable;

@Data
public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 293211213968858898L;

    private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }
}
