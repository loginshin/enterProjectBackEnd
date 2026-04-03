package com.enterProject.enterProject.auth.adapter.out.persistence;

import com.enterProject.enterProject.auth.adapter.out.persistence.entity.AuthUserEntity;
import com.enterProject.enterProject.auth.adapter.out.persistence.mapper.AuthUserMapper;
import com.enterProject.enterProject.auth.adapter.out.persistence.repository.AuthUserRepository;
import com.enterProject.enterProject.auth.application.port.out.SaveUserPort;
import com.enterProject.enterProject.auth.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthPersistenceAdapter implements SaveUserPort {

    private final AuthUserRepository userRepository;
    private final AuthUserMapper userMapper;

    @Override
    public void saveUser(User user) {
        AuthUserEntity entity = userMapper.toEntity(user);
        userRepository.save(entity);
    }
}
