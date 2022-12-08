package com.etec.mmusic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailAlreadyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EmailAlreadyException(String msg) {
        super(msg);
    }
}