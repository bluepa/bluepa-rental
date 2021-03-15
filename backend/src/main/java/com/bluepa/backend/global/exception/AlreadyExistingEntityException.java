package com.bluepa.backend.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AlreadyExistingEntityException extends RuntimeException {

    public AlreadyExistingEntityException(Class<?> entity, String field, String value) {
        super("이미 존재하는 객체입니다. "
            + "(" + entity.getSimpleName() + ": " + field + "=" + value + ")");
    }
}
