package com.github.cnproxy.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

}
