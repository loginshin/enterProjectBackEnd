package com.enterProject.enterProject.auth.adapter.out.persistence.mapper;

import com.enterProject.enterProject.auth.adapter.out.persistence.entity.AuthUserEntity;
import com.enterProject.enterProject.auth.domain.User;
import org.springframework.stereotype.Component;

@Component
public class AuthUserMapper {
    public AuthUserEntity toEntity(User user) {
        return AuthUserEntity.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .name(user.getName())
                .build();
    }

    public User toDomain(AuthUserEntity entity) {
        return User.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .name(entity.getName())
                .build();
    }
}
