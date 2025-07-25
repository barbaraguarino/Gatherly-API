package com.guarino.gatherlyapi.infrastructure.persistence.user.adapter;

import com.guarino.gatherlyapi.application.user.port.out.UserRepositoryPort;
import com.guarino.gatherlyapi.domain.user.model.User;
import com.guarino.gatherlyapi.infrastructure.persistence.user.entity.UserEntity;
import com.guarino.gatherlyapi.infrastructure.persistence.user.mapper.UserPersistenceMapper;
import com.guarino.gatherlyapi.infrastructure.persistence.user.repository.UserJpaRepository;

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
    public boolean existsByEmail(String email) {
        return jpaRepository.existsByEmail(email);
    }
}