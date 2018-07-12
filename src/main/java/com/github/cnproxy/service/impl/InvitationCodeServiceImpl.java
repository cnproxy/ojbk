package com.github.cnproxy.service.impl;

import com.github.cnproxy.entity.InvitationCode;
import com.github.cnproxy.mapper.InvitationCodeMapper;
import com.github.cnproxy.service.InvitationCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InvitationCodeServiceImpl implements InvitationCodeService {

    @Autowired
    private InvitationCodeMapper invitationCodeMapper;

    @Override
    public InvitationCode assignInvitationCode(final Integer userId) {
        InvitationCode invitationCode = new InvitationCode(userId);
        invitationCodeMapper.assignInvitationCode(invitationCode);
        log.debug("Invitation code : {}",invitationCode);
        return invitationCode;
    }
}
