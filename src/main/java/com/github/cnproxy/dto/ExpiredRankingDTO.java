package com.github.cnproxy.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 过期排行版
 * @author tomaer
 */
@Getter @Setter @ToString()
@EqualsAndHashCode()
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExpiredRankingDTO implements java.io.Serializable {

    private String vmessUUID;
    private Integer shadowsocksPort;
    private String shadowsocksPass;
    private Date beginTime;
    private Date expireTime;

    private String qq;

    private String serviceName;
    private String serviceType;
    private Integer price;

    public String getEmail() {
        return this.getQq().concat("@qq.com");
    }

    public String getVmessUUID() {
        return vmessUUID;
    }

    public ExpiredRankingDTO setVmessUUID(String vmessUUID) {
        this.vmessUUID = vmessUUID;
        return this;
    }

    public Integer getShadowsocksPort() {
        return shadowsocksPort;
    }

    public ExpiredRankingDTO setShadowsocksPort(Integer shadowsocksPort) {
        this.shadowsocksPort = shadowsocksPort;
        return this;
    }

    public String getShadowsocksPass() {
        return shadowsocksPass;
    }

    public ExpiredRankingDTO setShadowsocksPass(String shadowsocksPass) {
        this.shadowsocksPass = shadowsocksPass;
        return this;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public ExpiredRankingDTO setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
        return this;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public ExpiredRankingDTO setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
        return this;
    }

    public String getQq() {
        return qq;
    }

    public ExpiredRankingDTO setQq(String qq) {
        this.qq = qq;
        return this;
    }

    public String getServiceName() {
        return serviceName;
    }

    public ExpiredRankingDTO setServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public String getServiceType() {
        return serviceType;
    }

    public ExpiredRankingDTO setServiceType(String serviceType) {
        this.serviceType = serviceType;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public ExpiredRankingDTO setPrice(Integer price) {
        this.price = price;
        return this;
    }
}
