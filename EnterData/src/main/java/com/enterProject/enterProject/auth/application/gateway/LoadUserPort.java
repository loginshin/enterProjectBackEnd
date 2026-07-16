package com.enterProject.enterProject.auth.application.gateway;

import com.enterProject.enterProject.auth.domain.User;

import java.util.Optional;

public interface LoadUserPort {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
