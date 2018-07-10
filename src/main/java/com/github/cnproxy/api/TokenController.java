package com.github.cnproxy.api;

import com.github.cnproxy.secruity.JwtAuthenticationRequest;
import com.github.cnproxy.secruity.JwtAuthenticationResponse;
import com.github.cnproxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private UserService userService;

    @PostMapping("/access")
    public @ResponseBody ResponseEntity<JwtAuthenticationResponse> access(@RequestBody JwtAuthenticationRequest request) {
        final String token = userService.loginAndGenerateToken(request.getUsername(),request.getPassword());
        JwtAuthenticationResponse accessToken = new JwtAuthenticationResponse(token);
        return new ResponseEntity<JwtAuthenticationResponse>(accessToken, HttpStatus.OK);
    }
}
