package com.edozo.test.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class NotAcceptableEx extends RuntimeException {
    public NotAcceptableEx(String message) {
        super(message);
    }

    public NotAcceptableEx(String message, Throwable cause) {
        super(message, cause);
    }
}
