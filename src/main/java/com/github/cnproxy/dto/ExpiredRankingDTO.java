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
    private boolean expired;
    private String descript;
    private String username;

    private String serviceName;
    private String serviceType;
    private Integer price;

    public String getEmail() {
        return this.getUsername().concat("@qq.com");
    }
}
