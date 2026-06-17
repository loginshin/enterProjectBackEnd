package com.enterProject.enterProject.board.application.port.out;

import com.enterProject.enterProject.board.domain.Board;

public interface DeleteBoardPort {
    void delete(Board board);
}
