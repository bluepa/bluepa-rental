package com.bluepa.backend.user.service;

import com.bluepa.backend.user.dto.SignInRequest;
import com.bluepa.backend.user.dto.SignUpRequest;

public interface UserService {

    Long register(SignUpRequest signUpRequest);

    String signIn(SignInRequest request);
}
