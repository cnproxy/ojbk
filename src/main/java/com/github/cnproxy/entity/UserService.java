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

    private Integer userId;
    private Integer serviceId;
    private String vmessUUID;
    private Integer shadowsocksPort;
    private Integer shadowsocksPass;
    private Date beginTime;
    private Date expireTime;

}
