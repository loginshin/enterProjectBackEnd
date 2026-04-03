package com.enterProject.enterProject.auth.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {
    private final Long id;
    private final String email;
    private final String password;
    private final String name;

    public static User create(Long id, String email, String password, String name) {
        if (email == null || email.isBlank()) throw new IllegalArgumentException("이메일은 필수입니다.");
        return new User(id, email, password, name);
    }
}
