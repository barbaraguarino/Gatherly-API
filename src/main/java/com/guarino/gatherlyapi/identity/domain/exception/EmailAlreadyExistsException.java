package com.guarino.gatherlyapi.identity.domain.exception;

import lombok.Getter;

@Getter
public class EmailAlreadyExistsException extends RuntimeException {

    private final String email;

    public EmailAlreadyExistsException(String email) {
        super();
        this.email = email;
    }
}