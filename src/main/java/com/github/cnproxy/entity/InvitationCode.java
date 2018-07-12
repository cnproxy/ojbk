package com.github.cnproxy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter @Setter @ToString
@EqualsAndHashCode
public class InvitationCode implements java.io.Serializable {

    private static final long serialVersionUID = -456970136455002622L;

    private Integer id;
    /** 邀请码 */
    private String code;
    /** 分配给用户 */
    @JsonIgnore
    private Integer toUser;

    /** 是否被使用 */
    private boolean used;

    public InvitationCode(final Integer toUser) {
        this.setCode(UUID.randomUUID().toString());
        this.toUser = toUser;
    }
}
