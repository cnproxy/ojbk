package com.github.cnproxy.pto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@EqualsAndHashCode
public class InvitationCodePTO implements java.io.Serializable {

    private static final long serialVersionUID = -5366285099058583316L;

    private Integer userId;
}
