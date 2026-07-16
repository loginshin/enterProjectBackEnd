package com.enterProject.enterProject.hexagonal.adapter.out.persistence.repository;

import com.enterProject.enterProject.hexagonal.adapter.out.persistence.entity.HexagonalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HexagonalJpaRepository extends JpaRepository<HexagonalEntity, Long> {
}
