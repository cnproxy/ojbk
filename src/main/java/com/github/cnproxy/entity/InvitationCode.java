package com.github.cnproxy.entity;

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
    private Integer toUser;

    /** 是否被使用 */
    private boolean used;

    public InvitationCode() {
    }

    public InvitationCode(final Integer toUser) {
        this.setCode(UUID.randomUUID().toString());
        this.toUser = toUser;
    }

    public InvitationCode(Integer id, String code, Integer toUser, boolean used) {
        this.id = id;
        this.code = code;
        this.toUser = toUser;
        this.used = used;
    }
}
