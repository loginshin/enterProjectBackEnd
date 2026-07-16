package com.enterProject.enterProject.simplecleanarchitectureexample.infrastructure.persistence.repository;

import com.enterProject.enterProject.simplecleanarchitectureexample.infrastructure.persistence.entity.CleanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CleanJpaRepository extends JpaRepository<CleanEntity, Long> {
}
