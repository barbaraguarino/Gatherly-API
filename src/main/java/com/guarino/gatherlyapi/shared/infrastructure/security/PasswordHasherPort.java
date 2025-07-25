package com.guarino.gatherlyapi.shared.infrastructure.security;

public interface PasswordHasherPort {

    String encode(String rawPassword);

    boolean matches(String rawPassword, String encodedPassword);
}