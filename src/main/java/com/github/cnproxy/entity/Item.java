package com.github.cnproxy.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author cnproxy
 */
@Getter @Setter @ToString
@EqualsAndHashCode
public class Item implements java.io.Serializable {

    private static final long serialVersionUID = 5773555931257027059L;
    private Integer id;
    private String serviceName;
    private String serviceType;
    private Integer price;

    public Item setId(Integer id) {
        this.id = id;
        return this;
    }

    public Item setServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public Item setServiceType(String serviceType) {
        this.serviceType = serviceType;
        return this;
    }

    public Item setPrice(Integer price) {
        this.price = price;
        return this;
    }
}
