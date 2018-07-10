package com.github.cnproxy.api;

import com.github.cnproxy.dto.ExpiredRankingDTO;
import com.github.cnproxy.entity.User;
import com.github.cnproxy.service.ProxyService;
import com.github.cnproxy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sec")
@Slf4j
public class ApiController {

    @Autowired private ProxyService proxyService;

    @Autowired private UserService userService;

    @GetMapping("/expired/ranking")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ExpiredRankingDTO>> getExpiredRanking() {
        return new ResponseEntity<>(proxyService.getExpiredRanking(),HttpStatus.OK);
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<User> getUser() {
        final String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return new ResponseEntity<>(userService.getUser(username),HttpStatus.OK);
    }

}
