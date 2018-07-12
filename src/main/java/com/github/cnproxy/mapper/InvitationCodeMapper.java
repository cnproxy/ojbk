package com.github.cnproxy.mapper;

import com.github.cnproxy.entity.InvitationCode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InvitationCodeMapper {

    void assignInvitationCode(final InvitationCode invitationCode);

    List<InvitationCode> myInvitationCode(final Integer userId);

    InvitationCode findInvitationCode(final String code);

    void useInvitationCode(final String code);

    List<InvitationCode> findAllInvitationCode();
}
