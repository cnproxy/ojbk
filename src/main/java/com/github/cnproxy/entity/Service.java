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
public class Service extends BaseObject {

    private static final long serialVersionUID = 5773555931257027059L;

    private String serviceName;
    private String serviceType;
    private Integer price;

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

    @Override
    public Service setId(Integer id) {
        this.id = id;
        return this;
    }

    @Override
    public Service setCreationOn(Date creationOn) {
        this.creationOn = creationOn;
        return this;
    }

    @Override
    public Service setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
        return this;
    }

    @Override
    public Service setActive(Enum active) {
        this.active = active;
        return this;
    }
}
