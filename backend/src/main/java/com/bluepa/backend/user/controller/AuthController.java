package com.bluepa.backend.user.controller;

import com.bluepa.backend.user.dto.SignUpRequest;
import com.bluepa.backend.user.service.UserService;
import java.net.URI;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<?> register(@RequestBody SignUpRequest request) {
        Long userId = userService.register(request);
        return ResponseEntity.created(URI.create("/api/users/" + userId)).build();
    }
}
