package com.bluepa.backend.user.service;

import com.bluepa.backend.user.dto.EmailRequest;
import com.bluepa.backend.user.dto.SignInRequest;
import com.bluepa.backend.user.dto.SignUpRequest;

public interface UserService {

    Long signUp(SignUpRequest request);

    String signIn(SignInRequest request);

    void sendEmail(String email);

    void authenticateEmail(String email, int code);
}
