package com.enterProject.enterProject.cleanexample.infrastructure.persistence.repository;

import com.enterProject.enterProject.cleanexample.infrastructure.persistence.entity.CleanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CleanJpaRepository extends JpaRepository<CleanEntity, Long> {
}
