package com.enterProject.enterProject.board.repository;

import com.enterProject.enterProject.board.domain.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, String> {

}
