package com.github.cnproxy.secruity;

import lombok.Data;

import java.io.Serializable;

@Data
public class JwtAuthenticationRequest implements Serializable {

    private static final long serialVersionUID = -6390201915838274366L;

    private String qq;
    private String password;
}
