package com.github.cnproxy.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MyService implements java.io.Serializable {

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
    private Item item;
    private String descript;

    public MyService setId(Integer id) {
        this.id = id;
        return this;
    }

    public MyService setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public MyService setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    public MyService setVmessUUID(String vmessUUID) {
        this.vmessUUID = vmessUUID;
        return this;
    }

    public MyService setShadowsocksPort(Integer shadowsocksPort) {
        this.shadowsocksPort = shadowsocksPort;
        return this;
    }

    public MyService setShadowsocksPass(String shadowsocksPass) {
        this.shadowsocksPass = shadowsocksPass;
        return this;
    }

    public MyService setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
        return this;
    }

    public MyService setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
        return this;
    }

    public MyService setExpired(boolean expired) {
        this.expired = expired;
        return this;
    }

    public MyService setUser(User user) {
        this.user = user;
        return this;
    }

    public MyService setItem(Item item) {
        this.item = item;
        return this;
    }

    public MyService setDescript(String descript) {
        this.descript = descript;
        return this;
    }
}
