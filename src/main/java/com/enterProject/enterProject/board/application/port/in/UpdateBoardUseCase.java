package com.enterProject.enterProject.board.application.port.in;

import com.enterProject.enterProject.board.application.command.UpdateBoardCommand;
import com.enterProject.enterProject.board.application.result.BoardResult;

public interface UpdateBoardUseCase {
    BoardResult update(UpdateBoardCommand command);
}
