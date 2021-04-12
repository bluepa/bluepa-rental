package com.bluepa.backend.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundUserException extends RuntimeException {

    public NotFoundUserException(String email) {
        super("존재하지 않는 사용자입니다. " + "(email: " + email + ")");
    }
}
