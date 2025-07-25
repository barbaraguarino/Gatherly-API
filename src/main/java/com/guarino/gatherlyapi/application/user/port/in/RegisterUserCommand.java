package com.guarino.gatherlyapi.application.user.port.in;

public record RegisterUserCommand(
        String name,
        String email,
        String password
){}
