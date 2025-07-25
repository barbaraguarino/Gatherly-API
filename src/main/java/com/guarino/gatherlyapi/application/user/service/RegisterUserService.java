package com.guarino.gatherlyapi.application.user.service;

import com.guarino.gatherlyapi.application.user.port.in.RegisterUserCommand;
import com.guarino.gatherlyapi.application.user.port.in.RegisterUserUseCase;
import com.guarino.gatherlyapi.application.user.port.out.PasswordHasherPort;
import com.guarino.gatherlyapi.application.user.port.out.UserRepositoryPort;
import com.guarino.gatherlyapi.domain.user.exception.EmailAlreadyExistsException;
import com.guarino.gatherlyapi.domain.user.model.User;

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
        if (userRepositoryPort.existsByEmail(email))
            throw new EmailAlreadyExistsException(email);
    }
}
