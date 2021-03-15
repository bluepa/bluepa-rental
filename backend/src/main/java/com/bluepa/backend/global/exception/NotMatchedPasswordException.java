package com.bluepa.backend.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class NotMatchedPasswordException extends RuntimeException {

    public NotMatchedPasswordException() {
        super("비밀번호가 일치하지 않습니다.");
    }
}
