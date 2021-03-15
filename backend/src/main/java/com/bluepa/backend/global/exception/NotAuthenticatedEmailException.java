package com.bluepa.backend.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class NotAuthenticatedEmailException extends RuntimeException {

    public NotAuthenticatedEmailException(String email) {
        super("인증되지 않은 이메일입니다. (email=" + email + ")");
    }
}
