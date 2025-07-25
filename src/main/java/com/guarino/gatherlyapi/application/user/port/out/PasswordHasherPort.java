package com.guarino.gatherlyapi.application.user.port.out;

public interface PasswordHasherPort {

    String encode(String rawPassword);

    boolean matches(String rawPassword, String encodedPassword);
}
