package com.guarino.gatherlyapi.identity.application.port.out;

import com.guarino.gatherlyapi.identity.domain.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryPort {

    User save(User user);

    Optional<User> findById(UUID id);

    Optional<User> findByEmail(String email);

    boolean existsByEmailIgnoreCase(String email);
}