package com.edozo.test.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class NotAuthorizedEx extends RuntimeException {
    public NotAuthorizedEx(String message) {
        super(message);
    }
}
