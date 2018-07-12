package com.github.cnproxy.pto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@EqualsAndHashCode
public class UpdatePasswordPTO implements java.io.Serializable {

    private static final long serialVersionUID = -8135407982191171057L;
    private String username;
    private String oldPassword;
    private String newPassword;
    private String reNewPassword;


}
