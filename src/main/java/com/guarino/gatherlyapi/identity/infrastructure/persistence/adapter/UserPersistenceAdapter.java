package com.guarino.gatherlyapi.identity.infrastructure.persistence.adapter;

import com.guarino.gatherlyapi.identity.application.port.out.UserRepositoryPort;
import com.guarino.gatherlyapi.identity.domain.model.User;
import com.guarino.gatherlyapi.identity.infrastructure.persistence.entity.UserEntity;
import com.guarino.gatherlyapi.identity.infrastructure.persistence.mapper.UserPersistenceMapper;
import com.guarino.gatherlyapi.identity.infrastructure.persistence.repository.UserJpaRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserRepositoryPort {

    private final UserJpaRepository jpaRepository;
    private final UserPersistenceMapper userPersistenceMapper;

    @Override
    public User save(User user) {
        UserEntity userEntity = userPersistenceMapper.toEntity(user);
        UserEntity savedEntity = jpaRepository.save(userEntity);
        return userPersistenceMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return jpaRepository.findById(id)
                .map(userPersistenceMapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaRepository.findByEmail(email)
                .map(userPersistenceMapper::toDomain);
    }

    @Override
    public boolean existsByEmailIgnoreCase(String email) {
        return jpaRepository.existsByEmailIgnoreCase(email);
    }
}