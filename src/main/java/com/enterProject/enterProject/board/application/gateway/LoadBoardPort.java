package com.enterProject.enterProject.board.application.gateway;

import com.enterProject.enterProject.board.domain.Board;

import java.util.Optional;

public interface LoadBoardPort {
    Optional<Board> findById(String boardKey);
}
