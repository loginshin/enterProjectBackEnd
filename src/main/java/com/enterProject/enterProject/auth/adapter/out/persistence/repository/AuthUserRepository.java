package com.enterProject.enterProject.auth.adapter.out.persistence.repository;

import com.enterProject.enterProject.auth.adapter.out.persistence.entity.AuthUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserRepository extends JpaRepository<AuthUserEntity, Long> {
}
