package com.guarino.gatherlyapi.domain.exception;

public class EmailAlreadyExistsException extends RuntimeException {

    private final String email;

    public EmailAlreadyExistsException(String email) {
        super();
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}