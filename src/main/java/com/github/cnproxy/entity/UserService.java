package com.github.cnproxy.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author cnproxy
 */
@Getter @Setter @ToString
@EqualsAndHashCode
public class UserService implements java.io.Serializable {

    private static final long serialVersionUID = -1428136747947282550L;

    private Integer id;
    private Integer userId;
    private Integer serviceId;
    private String vmessUUID;
    private Integer shadowsocksPort;
    private String shadowsocksPass;
    private Date beginTime;
    private Date expireTime;
    private boolean expired;

    private User user;
    private Service service;
    private String descript;

    public UserService setId(Integer id) {
        this.id = id;
        return this;
    }

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

    public UserService setExpired(boolean expired) {
        this.expired = expired;
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
