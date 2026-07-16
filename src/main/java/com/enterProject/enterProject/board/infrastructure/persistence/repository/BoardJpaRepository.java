package com.enterProject.enterProject.board.infrastructure.persistence.repository;

import com.enterProject.enterProject.board.infrastructure.persistence.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardJpaRepository extends JpaRepository<BoardEntity, String> {
}
