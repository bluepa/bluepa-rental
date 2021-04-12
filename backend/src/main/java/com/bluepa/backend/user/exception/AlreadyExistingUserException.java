package com.bluepa.backend.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AlreadyExistingUserException extends RuntimeException {

    public AlreadyExistingUserException(Class<?> entity, String field, String value) {
        super("이미 존재하는 사용자입니다. "
            + "(" + entity.getSimpleName() + ": " + field + "=" + value + ")");
    }
}
