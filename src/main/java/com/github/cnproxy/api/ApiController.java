package com.github.cnproxy.api;

import com.github.cnproxy.dto.ExpiredRankingDTO;
import com.github.cnproxy.entity.InvitationCode;
import com.github.cnproxy.entity.User;
import com.github.cnproxy.pto.InvitationCodePTO;
import com.github.cnproxy.pto.UpdatePasswordPTO;
import com.github.cnproxy.secruity.JwtUser;
import com.github.cnproxy.service.InvitationCodeService;
import com.github.cnproxy.service.ProxyService;
import com.github.cnproxy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.security.core.context.SecurityContextHolder.getContext;

@RestController
@RequestMapping("/api/sec")
@Slf4j
public class ApiController {

    @Autowired private ProxyService proxyService;

    @Autowired private UserService userService;

    @Autowired private InvitationCodeService invitationCodeService;

    @GetMapping("/expired/ranking")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ExpiredRankingDTO>> getExpiredRanking() {
        return new ResponseEntity<>(proxyService.getExpiredRanking(),HttpStatus.OK);
    }

    @PostMapping("/invitationcode")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<InvitationCode> assignInvitationCode(@RequestBody InvitationCodePTO pto) {
        return new ResponseEntity<>(invitationCodeService.assignInvitationCode(pto.getUserId()),HttpStatus.OK);
    }

    @GetMapping("/invitationcode")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<InvitationCode>> allInvitationCode() {
        return new ResponseEntity<>(invitationCodeService.findAllInvitationCode(),HttpStatus.OK);
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<User> getUser() {
        final String username = getContext().getAuthentication().getName();
        return new ResponseEntity<>(userService.getUser(username),HttpStatus.OK);
    }

    @GetMapping("/user/identity")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Map<String,List<String>>> getIdentity() {
        List<SimpleGrantedAuthority> authorities = (List<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        final List<String> roles = authorities.stream().map(SimpleGrantedAuthority::getAuthority).collect(Collectors.toList());
        Map<String,List<String>> result = new HashMap<>();
        result.put("identity",roles);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/user/invitationcode")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<InvitationCode>> assignInvitationCode() {
        JwtUser user = (JwtUser) getContext().getAuthentication().getPrincipal();
        log.debug("{}", user);
        return new ResponseEntity<>(invitationCodeService.myInvitationCode(user.getId()),HttpStatus.OK);
    }

    @PutMapping("/user/password")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity updatePassword(@RequestBody UpdatePasswordPTO pto) {
        JwtUser user = (JwtUser) getContext().getAuthentication().getPrincipal();
        pto.setUsername(user.getUsername());
        userService.updatePassword(pto);
        return new ResponseEntity(HttpStatus.OK);
    }

}
