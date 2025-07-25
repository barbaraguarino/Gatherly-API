package com.guarino.gatherlyapi.identity.application.port.in;

import com.guarino.gatherlyapi.identity.domain.model.User;

public interface RegisterUserUseCase {
    User execute(RegisterUserCommand command);
}