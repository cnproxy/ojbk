package com.github.cnproxy.pto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@EqualsAndHashCode
public class UserPTO implements java.io.Serializable {

    private static final long serialVersionUID = 5482612811271289577L;

    private String username;
    private String password;
    private String invitationCode;

}
