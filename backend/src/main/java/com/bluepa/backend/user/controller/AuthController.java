package com.bluepa.backend.user.controller;

import com.bluepa.backend.global.security.JwtProperties;
import com.bluepa.backend.user.dto.EmailRequest;
import com.bluepa.backend.user.dto.SignInRequest;
import com.bluepa.backend.user.dto.SignUpRequest;
import com.bluepa.backend.user.service.UserService;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest request) {
        Long userId = userService.signUp(request);
        return ResponseEntity.created(URI.create("/api/users/" + userId)).build();
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestBody SignInRequest request) {
        String token = userService.signIn(request);
        HttpHeaders headers = new HttpHeaders();
        headers.add(JwtProperties.HEADER, JwtProperties.TYPE + " " + token);
        return ResponseEntity.ok().headers(headers).build();
    }

    @PostMapping("/mail/send")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request) {
        userService.sendEmail(request.getEmail());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/mail/check")
    public ResponseEntity<?> authenticateEmail(@RequestBody EmailRequest request) {
        userService.authenticateEmail(request.getEmail(), request.getCode());
        return ResponseEntity.ok().build();
    }
}
