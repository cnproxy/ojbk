package com.github.cnproxy.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

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

    public User setQq(String qq) {
        this.qq = qq;
        return this;
    }

    public User setPass(String pass) {
        this.pass = pass;
        return this;
    }

    public User setInviteBy(Integer inviteBy) {
        this.inviteBy = inviteBy;
        return this;
    }

    public String getEmail() {
        return this.getQq().concat("@qq.com");
    }

    @Override
    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    @Override
    public User setCreationOn(Date creationOn) {
        this.creationOn = creationOn;
        return this;
    }

    @Override
    public Object setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
        return this;
    }

    @Override
    public Object setActive(Enum active) {
        this.active = active;
        return this;
    }
}
