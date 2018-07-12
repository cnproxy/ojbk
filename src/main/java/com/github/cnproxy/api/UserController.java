package com.github.cnproxy.api;

import com.github.cnproxy.entity.User;
import com.github.cnproxy.pto.UserPTO;
import com.github.cnproxy.secruity.JwtAuthenticationRequest;
import com.github.cnproxy.secruity.JwtAuthenticationResponse;
import com.github.cnproxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserPTO user) {
        userService.register(user);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/token")
    public ResponseEntity<JwtAuthenticationResponse> access(@RequestBody JwtAuthenticationRequest request) {
        final String token = userService.loginAndGenerateToken(request.getUsername(),request.getPassword());
        JwtAuthenticationResponse accessToken = new JwtAuthenticationResponse(token);
        return new ResponseEntity<JwtAuthenticationResponse>(accessToken, HttpStatus.OK);
    }
}
