package com.github.cnproxy.secruity;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

@Data
public class JwtAuthenticationRequest implements Serializable {

    private static final long serialVersionUID = -6390201915838274366L;

    @NotBlank private String username;
    @NotBlank private String password;
}
