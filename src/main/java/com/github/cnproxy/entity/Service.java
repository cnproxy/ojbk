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
public class Service implements java.io.Serializable {

    private static final long serialVersionUID = 5773555931257027059L;
    private Integer id;
    private String serviceName;
    private String serviceType;
    private Integer price;

    public Service setId(Integer id) {
        this.id = id;
        return this;
    }

    public Service setServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public Service setServiceType(String serviceType) {
        this.serviceType = serviceType;
        return this;
    }

    public Service setPrice(Integer price) {
        this.price = price;
        return this;
    }
}
