package com.guarino.gatherlyapi.application.service;

import com.guarino.gatherlyapi.application.port.in.user.RegisterUserCommand;
import com.guarino.gatherlyapi.application.port.in.user.RegisterUserUseCase;
import com.guarino.gatherlyapi.application.port.out.PasswordHasherPort;
import com.guarino.gatherlyapi.application.port.out.UserRepositoryPort;
import com.guarino.gatherlyapi.domain.exception.EmailAlreadyExistsException;
import com.guarino.gatherlyapi.domain.model.user.User;
import com.guarino.gatherlyapi.domain.model.user.UserRole;
import com.guarino.gatherlyapi.domain.model.user.UserStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.UUID;

@Service
@Transactional
public class RegisterUserService implements RegisterUserUseCase {

    private final UserRepositoryPort userRepositoryPort;
    private final PasswordHasherPort passwordHasherPort;

    public RegisterUserService(UserRepositoryPort userRepositoryPort, PasswordHasherPort passwordHasherPort) {
        this.userRepositoryPort = userRepositoryPort;
        this.passwordHasherPort = passwordHasherPort;
    }

    @Override
    public User execute(RegisterUserCommand command) {
        if (userRepositoryPort.existsByEmail(command.email())) {
            throw new EmailAlreadyExistsException(command.email());
        }

        String hashedPassword = passwordHasherPort.encode(command.password());

        User newUser = new User(
                UUID.randomUUID(),
                command.name(),
                command.email(),
                hashedPassword,
                UserRole.USER,
                UserStatus.PENDING_VERIFICATION,
                ZonedDateTime.now(),
                ZonedDateTime.now()
        );

        return userRepositoryPort.save(newUser);
    }
}
