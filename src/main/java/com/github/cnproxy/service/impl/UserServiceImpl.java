package com.github.cnproxy.service.impl;

import com.github.cnproxy.entity.InvitationCode;
import com.github.cnproxy.entity.User;
import com.github.cnproxy.mapper.UserMapper;
import com.github.cnproxy.pto.UpdatePasswordPTO;
import com.github.cnproxy.pto.UserPTO;
import com.github.cnproxy.secruity.JwtTokenUtil;
import com.github.cnproxy.secruity.JwtUser;
import com.github.cnproxy.secruity.JwtUserFactory;
import com.github.cnproxy.service.InvitationCodeService;
import com.github.cnproxy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author cnproxy
 */

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private InvitationCodeService invitationCodeService;

    private final static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public String loginAndGenerateToken(final String username, final String password) {
        User user = findUserByUsername(username);
        if(null != user) {
            if (encoder.matches(password,user.getPassword())) {
                final Integer userId = user.getId();
                user = findUserById(userId);
                return generateToken(user);
            }
        }
        return null;
    }

    @Override
    public User findUserById(Integer userId) {
        return userMapper.findUserByUserId(userId);
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public User getUser(final String username) {
        return userMapper.getUser(username);
    }

    /**
     * 产生 token
     * @param user
     * @return
     */
    private String generateToken(final User user) {
        JwtUser jwtUser = JwtUserFactory.create(
                user.getId(),user.getUsername(),user.getPassword(),
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList()),
                user.isEnabled());
        return jwtTokenUtil.generateToken(jwtUser);
    }


    @Override
    public void register(final UserPTO user) {
        InvitationCode invitationCode = invitationCodeService.findInvitationCode(user.getInvitationCode());
        if(Objects.isNull(invitationCode) || invitationCode.isUsed()) {
            log.error("Invitation code is invalidate");
        } else {
            final String bcryptPassword = encoder.encode(user.getPassword());
            log.info("User {} password is {}", user.getUsername(), bcryptPassword);
            User saveUser = new User().setUsername(user.getUsername()).setPassword(bcryptPassword).setInviteBy(invitationCode.getToUser());
            userMapper.saveUser(saveUser);
            userMapper.grantUserRole(saveUser.getId());
            invitationCodeService.useInvitationCode(invitationCode.getCode());
        }
    }

    @Override
    public void updatePassword(UpdatePasswordPTO updatePasswordPTO) {
        final String password = updatePasswordPTO.getOldPassword();
        final String newPassword = updatePasswordPTO.getNewPassword();
        final String reNewPassword = updatePasswordPTO.getReNewPassword();
        if(!reNewPassword.equals(newPassword)) {
            log.error("The newPassword not same as reNewPassword");
            throw new RuntimeException("The newPassword not same as reNewPassword");
        }
        final String username = updatePasswordPTO.getUsername();
        final User user = userMapper.findUserByUsername(username);
        if(!encoder.matches(password, user.getPassword())) {
            log.error("The oldPassword is error");
            throw new RuntimeException("The oldPassword is error");
        }
        final String bcryptPassword = encoder.encode(newPassword);
        userMapper.updatePassword(username,bcryptPassword);
    }
}
