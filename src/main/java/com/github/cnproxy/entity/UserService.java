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
public class UserService extends BaseObject {

    private static final long serialVersionUID = -1428136747947282550L;

    private Integer userId;
    private Integer serviceId;
    private String vmessUUID;
    private Integer shadowsocksPort;
    private String shadowsocksPass;
    private Date beginTime;
    private Date expireTime;

    private User user;
    private Service service;
    private String descript;

    public UserService setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public UserService setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    public UserService setVmessUUID(String vmessUUID) {
        this.vmessUUID = vmessUUID;
        return this;
    }

    public UserService setShadowsocksPort(Integer shadowsocksPort) {
        this.shadowsocksPort = shadowsocksPort;
        return this;
    }

    public UserService setShadowsocksPass(String shadowsocksPass) {
        this.shadowsocksPass = shadowsocksPass;
        return this;
    }

    public UserService setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
        return this;
    }

    public UserService setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
        return this;
    }

    @Override
    public UserService setId(Integer id) {
        this.id = id;
        return this;
    }

    @Override
    public UserService setCreationOn(Date creationOn) {
        this.creationOn = creationOn;
        return this;
    }

    @Override
    public UserService setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
        return this;
    }

    @Override
    public UserService setActive(Enum active) {
        this.active = active;
        return this;
    }

    public UserService setUser(User user) {
        this.user = user;
        return this;
    }

    public UserService setService(Service service) {
        this.service = service;
        return this;
    }

    public UserService setDescript(String descript) {
        this.descript = descript;
        return this;
    }
}
