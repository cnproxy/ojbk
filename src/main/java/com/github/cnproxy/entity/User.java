package com.github.cnproxy.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author cnproxy
 */
@Getter @Setter @ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable {

    private static final long serialVersionUID = 6194284054791236795L;

    private Integer id;
    @NotBlank private String username;
    @NotBlank private String password;
    private boolean enabled = true;
    private Date creationOn;
    private Date modifiedOn;
    private Integer inviteBy;

    private List<UserService> userServices;
    private List<String> roles;

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public User setCreationOn(Date creationOn) {
        this.creationOn = creationOn;
        return this;
    }

    public User setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
        return this;
    }

    public User setInviteBy(Integer inviteBy) {
        this.inviteBy = inviteBy;
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

    public String getEmail() {
        return this.username.concat("@qq.com");
    }
}
