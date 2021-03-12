package com.bluepa.backend.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class NotAuthenticatedEmailException extends RuntimeException {

    public NotAuthenticatedEmailException() {
        super();
    }
}
