package com.github.cnproxy.api;

import com.github.cnproxy.dto.ExpiredRankingDTO;
import com.github.cnproxy.entity.User;
import com.github.cnproxy.service.ProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sec")
public class ApiController {

    @Autowired private ProxyService proxyService;

    @GetMapping("/user")
    public ResponseEntity<User> getUser(@RequestParam("qq") final String qq) {
        return new ResponseEntity<User>(proxyService.getUser(qq),HttpStatus.OK);
    }

    @GetMapping("/expired/ranking")
    public ResponseEntity<List<ExpiredRankingDTO>> getExpiredRanking() {
        return new ResponseEntity<List<ExpiredRankingDTO>>(proxyService.getExpiredRanking(),HttpStatus.OK);
    }
    
}
