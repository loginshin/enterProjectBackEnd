package com.enterProject.enterProject.user.repository;

import com.enterProject.enterProject.user.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>, UserRepositoryCustom {
    boolean existsByUserId(String userId);
}
