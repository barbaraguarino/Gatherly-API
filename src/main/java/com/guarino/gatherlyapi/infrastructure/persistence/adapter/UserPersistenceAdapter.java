package com.guarino.gatherlyapi.infrastructure.persistence.adapter;

import com.guarino.gatherlyapi.application.port.out.UserRepositoryPort;
import com.guarino.gatherlyapi.domain.model.user.User;
import com.guarino.gatherlyapi.infrastructure.persistence.entity.UserEntity;
import com.guarino.gatherlyapi.infrastructure.persistence.mapper.UserMapper;
import com.guarino.gatherlyapi.infrastructure.persistence.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserRepositoryPort {

    private final UserJpaRepository jpaRepository;
    private final UserMapper userMapper;

    @Override
    public User save(User user) {
        UserEntity userEntity = userMapper.toEntity(user);
        UserEntity savedEntity = jpaRepository.save(userEntity);
        return userMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return jpaRepository.findById(id)
                .map(userMapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaRepository.findByEmail(email)
                .map(userMapper::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaRepository.existsByEmail(email);
    }
}
