package com.guarino.gatherlyapi.application.user.port.in;

import com.guarino.gatherlyapi.domain.user.model.User;

public interface RegisterUserUseCase {
    User execute(RegisterUserCommand command);
}
