package com.github.cnproxy.mapper;

import com.github.cnproxy.entity.InvitationCode;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InvitationCodeMapper {

    void assignInvitationCode(final InvitationCode invitationCode);
}
