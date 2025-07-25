package com.guarino.gatherlyapi.application.service;

import com.guarino.gatherlyapi.application.port.in.user.RegisterUserCommand;
import com.guarino.gatherlyapi.application.port.in.user.RegisterUserUseCase;
import com.guarino.gatherlyapi.application.port.out.PasswordHasherPort;
import com.guarino.gatherlyapi.application.port.out.UserRepositoryPort;
import com.guarino.gatherlyapi.domain.exception.EmailAlreadyExistsException;
import com.guarino.gatherlyapi.domain.model.user.User;
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
        if (userRepositoryPort.existsByEmail(command.email())) {
            throw new EmailAlreadyExistsException(command.email());
        }
        String hashedPassword = passwordHasherPort.encode(command.password());
        User newUser = User.create(
                command.name(),
                command.email(),
                hashedPassword
        );
        return userRepositoryPort.save(newUser);
    }
}
