package com.guarino.gatherlyapi.application.user.port.out;

import com.guarino.gatherlyapi.domain.user.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryPort {

    User save(User user);

    Optional<User> findById(UUID id);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}