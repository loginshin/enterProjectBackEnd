package com.enterProject.enterProject.board.application.port.in;

import com.enterProject.enterProject.board.application.result.BoardResult;

public interface GetBoardUseCase {
    BoardResult get(String boardKey);
}
