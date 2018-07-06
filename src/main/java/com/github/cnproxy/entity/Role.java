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
public class Role implements java.io.Serializable {

    private static final long serialVersionUID = -6052524753069726647L;
    private Integer id;
    private Integer name;

    public Role setId(Integer id) {
        this.id = id;
        return this;
    }

    public Role setName(Integer name) {
        this.name = name;
        return this;
    }
}
