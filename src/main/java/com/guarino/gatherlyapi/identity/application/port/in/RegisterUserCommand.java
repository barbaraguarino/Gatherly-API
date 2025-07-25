package com.guarino.gatherlyapi.identity.application.port.in;

public record RegisterUserCommand(
        String name,
        String email,
        String password
){}
