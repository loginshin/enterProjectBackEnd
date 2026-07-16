package com.enterProject.enterProject.hexagonalexample.adapter.out.persistence.repository;

import com.enterProject.enterProject.hexagonalexample.adapter.out.persistence.entity.HexagonalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HexagonalJpaRepository extends JpaRepository<HexagonalEntity, Long> {
}
