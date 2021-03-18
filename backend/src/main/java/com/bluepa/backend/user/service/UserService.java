package com.bluepa.backend.user.service;

import com.bluepa.backend.user.dto.SignInRequest;
import com.bluepa.backend.user.dto.SignUpRequest;
import javax.servlet.http.HttpSession;

public interface UserService {

    Long signUp(SignUpRequest request);

    String signIn(SignInRequest request);

    String signIn(HttpSession httpSession);

    void sendEmail(String email);

    void authenticateEmail(String email, int code);
}
