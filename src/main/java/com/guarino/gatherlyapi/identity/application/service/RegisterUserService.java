package com.guarino.gatherlyapi.identity.application.service;

import com.guarino.gatherlyapi.identity.application.port.in.RegisterUserCommand;
import com.guarino.gatherlyapi.identity.application.port.in.RegisterUserUseCase;
import com.guarino.gatherlyapi.shared.infrastructure.security.PasswordHasherPort;
import com.guarino.gatherlyapi.identity.application.port.out.UserRepositoryPort;
import com.guarino.gatherlyapi.identity.domain.exception.EmailAlreadyExistsException;
import com.guarino.gatherlyapi.identity.domain.model.User;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RegisterUserService implements RegisterUserUseCase {

    private final UserRepositoryPort userRepositoryPort;
    private final PasswordHasherPort passwordHasherPort;

    @Override
    public User execute(RegisterUserCommand command) {
        this.validateEmailUniqueness(command.email());
        String hashedPassword = passwordHasherPort.encode(command.password());
        User newUser = User.create(
                command.name(),
                command.email(),
                hashedPassword
        );
        return userRepositoryPort.save(newUser);
    }

    private void validateEmailUniqueness(String email) {
        if (userRepositoryPort.existsByEmailIgnoreCase(email))
            throw new EmailAlreadyExistsException(email);
    }
}