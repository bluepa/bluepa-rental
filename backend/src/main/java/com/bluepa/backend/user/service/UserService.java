package com.bluepa.backend.user.service;

import com.bluepa.backend.user.dto.SignUpRequest;

public interface UserService {

    Long register(SignUpRequest signUpRequest);
}
