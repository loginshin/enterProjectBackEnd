package com.enterProject.enterProject.board.adapter.out.persistence.repository;

import com.enterProject.enterProject.board.adapter.out.persistence.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardJpaRepository extends JpaRepository<BoardEntity, String> {
}
