package com.github.cnproxy.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author cnproxy
 */
@Getter @Setter @ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class User extends BaseObject {

    private static final long serialVersionUID = 6194284054791236795L;

    private String qq;
    private String pass;
    private Integer inviteBy;

    public String getEmail() {
        return this.getQq().concat("@qq.com");
    }

}
