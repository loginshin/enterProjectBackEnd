package com.enterProject.enterProject.board.application.gateway;

import com.enterProject.enterProject.board.domain.Board;

public interface DeleteBoardPort {
    void delete(Board board);
}
