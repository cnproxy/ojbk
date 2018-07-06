package com.github.cnproxy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * @author cnproxy
 */
@Getter @Setter @ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class User extends BaseObject {

    private static final long serialVersionUID = 6194284054791236795L;

    private String username;
    @JsonIgnore
    private String pass;
    private Integer inviteBy;

    private List<UserService> userServices;
    private List<String> roles;

    public User setUsername(String username) {
        this.username = username;
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
        return this.getUsername().concat("@qq.com");
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

    public User setUserServices(List<UserService> userServices) {
        this.userServices = userServices;
        return this;
    }

    public User setRoles(List<String> roles) {
        this.roles = roles;
        return this;
    }
}
