package com.enterProject.enterProject.board.application.port.in;

import com.enterProject.enterProject.board.application.command.CreateBoardCommand;
import com.enterProject.enterProject.board.application.result.BoardResult;

public interface CreateBoardUseCase {
    BoardResult create(CreateBoardCommand command);
}
