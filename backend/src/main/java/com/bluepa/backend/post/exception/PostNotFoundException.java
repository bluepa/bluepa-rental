package com.bluepa.backend.post.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(Class<?> entity, String field, String value) {
        super("글이 존재하지 않습니다. "
                + "(" + entity.getSimpleName() + ": " + field + "=" + value + ")");
    }
}
