package com.enterProject.enterProject.cleanarchitectureexample.infrastructure.persistence.repository;

import com.enterProject.enterProject.cleanarchitectureexample.infrastructure.persistence.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleJpaRepository extends JpaRepository<ArticleEntity, Long> {
}
