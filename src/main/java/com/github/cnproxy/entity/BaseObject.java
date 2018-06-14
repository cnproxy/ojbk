package com.github.cnproxy.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author cnproxy
 */
@Getter @Setter @ToString
@EqualsAndHashCode
public class BaseObject implements Serializable {

    protected Integer id;
    protected Date creationOn;
    protected Date modifiedOn;
    protected Enum active;
}
