package com.github.cnproxy.service;

import com.github.cnproxy.entity.InvitationCode;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface InvitationCodeService {

    /**
     * 发放邀请码
     * @param userId 发放给的用户
     */
    @Transactional(propagation = Propagation.REQUIRED)
    InvitationCode assignInvitationCode(final Integer userId);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    List<InvitationCode> myInvitationCode(final Integer userId);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    InvitationCode findInvitationCode(final String code);

    @Transactional(propagation = Propagation.REQUIRED)
    void useInvitationCode(final String code);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    List<InvitationCode> findAllInvitationCode();
}
