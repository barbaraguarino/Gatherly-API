package com.guarino.gatherlyapi.application.port.in.user;

public record RegisterUserCommand(
        String name,
        String email,
        String password
){}
