package com.guarino.gatherlyapi.identity.infrastructure.persistence.repository;

import com.guarino.gatherlyapi.identity.infrastructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByEmail(String email);

    boolean existsByEmailIgnoreCase(String email);
}