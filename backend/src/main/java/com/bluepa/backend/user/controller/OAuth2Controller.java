package com.bluepa.backend.user.controller;

import com.bluepa.backend.global.security.JwtProperties;
import com.bluepa.backend.user.service.UserService;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/oauth2")
@RequiredArgsConstructor
public class OAuth2Controller {

    private final UserService userService;
    private final HttpSession httpSession;

    @GetMapping("/sign-in")
    public ResponseEntity<?> signIn() {
        String token = userService.signIn(httpSession);
        HttpHeaders headers = new HttpHeaders();
        headers.add(JwtProperties.HEADER, JwtProperties.TYPE + " " + token);
        return ResponseEntity.ok().headers(headers).build();
    }
}
