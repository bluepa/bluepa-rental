package com.bluepa.backend.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundEntityException extends RuntimeException {

    public NotFoundEntityException(Class<?> entity, String field, String value) {
        super("존재하지 않는 객체입니다. "
            + "(" + entity.getSimpleName() + ": " + field + "=" + value + ")");
    }
}
