package com.github.cnproxy.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class BaseObject<T> implements Serializable {

    private static final long serialVersionUID = 6572642668149697331L;

    protected Integer id;
    protected Date creationOn;
    protected Date modifiedOn;
    protected Enum active;

    public abstract <T> T setId(Integer id);
    public abstract <T> T setCreationOn(Date creationOn);
    public abstract <T> T setModifiedOn(Date modifiedOn);
    public abstract <T> T setActive(Enum active);

}
