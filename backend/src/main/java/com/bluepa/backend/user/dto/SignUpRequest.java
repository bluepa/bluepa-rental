package com.bluepa.backend.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SignUpRequest {

    private final String email;
    private final String password;
    private final String nickname;

    @Builder
    public SignUpRequest(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }
}
