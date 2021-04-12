package com.bluepa.backend.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DifferentCodeException extends RuntimeException {

    public DifferentCodeException() {
        super("올바르지 않은 인증번호입니다.");
    }
}
