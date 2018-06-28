package com.github.cnproxy.api;

import com.github.cnproxy.entity.User;
import com.github.cnproxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sec")
public class ApiController {

    @Autowired private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<User> getUser(@RequestParam("qq") final String qq) {
        return new ResponseEntity<User>(userService.getUser(qq),HttpStatus.OK);
    }

    
}
