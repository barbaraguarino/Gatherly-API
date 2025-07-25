package com.guarino.gatherlyapi.application.port.in.user;

import com.guarino.gatherlyapi.domain.model.user.User;

public interface RegisterUserUseCase {
    User execute(RegisterUserCommand command);
}
