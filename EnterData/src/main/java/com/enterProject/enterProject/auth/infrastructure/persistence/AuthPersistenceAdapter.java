package com.enterProject.enterProject.auth.infrastructure.persistence;

import com.enterProject.enterProject.auth.infrastructure.persistence.entity.AuthUserEntity;
import com.enterProject.enterProject.auth.infrastructure.persistence.mapper.AuthUserMapper;
import com.enterProject.enterProject.auth.infrastructure.persistence.repository.AuthUserRepository;
import com.enterProject.enterProject.auth.application.gateway.LoadUserPort;
import com.enterProject.enterProject.auth.application.gateway.SaveUserPort;
import com.enterProject.enterProject.auth.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthPersistenceAdapter implements SaveUserPort, LoadUserPort {

    private final AuthUserRepository userRepository;
    private final AuthUserMapper userMapper;

    @Override
    public void saveUser(User user) {
        AuthUserEntity entity = userMapper.toEntity(user);
        userRepository.save(entity);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userMapper::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
