package com.enterProject.enterProject.board.application.service;

import com.enterProject.enterProject.board.application.command.CreateBoardCommand;
import com.enterProject.enterProject.board.application.command.UpdateBoardCommand;
import com.enterProject.enterProject.board.application.usecase.CreateBoardUseCase;
import com.enterProject.enterProject.board.application.usecase.DeleteBoardUseCase;
import com.enterProject.enterProject.board.application.usecase.GetBoardUseCase;
import com.enterProject.enterProject.board.application.usecase.UpdateBoardUseCase;
import com.enterProject.enterProject.board.application.gateway.DeleteBoardPort;
import com.enterProject.enterProject.board.application.gateway.LoadBoardPort;
import com.enterProject.enterProject.board.application.gateway.SaveBoardPort;
import com.enterProject.enterProject.board.application.result.BoardResult;
import com.enterProject.enterProject.board.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardApplicationService implements CreateBoardUseCase, GetBoardUseCase, UpdateBoardUseCase, DeleteBoardUseCase {

    private final SaveBoardPort saveBoardPort;
    private final LoadBoardPort loadBoardPort;
    private final DeleteBoardPort deleteBoardPort;

    @Override
    public BoardResult create(CreateBoardCommand command) {
        Board board = Board.create(command.title(), command.contents(), command.userKey());
        return BoardResult.from(saveBoardPort.save(board));
    }

    @Override
    @Transactional(readOnly = true)
    public BoardResult get(String boardKey) {
        return BoardResult.from(loadBoard(boardKey));
    }

    @Override
    public BoardResult update(UpdateBoardCommand command) {
        Board board = loadBoard(command.boardKey())
                .update(command.title(), command.contents(), command.userKey());
        return BoardResult.from(saveBoardPort.save(board));
    }

    @Override
    public void delete(String boardKey) {
        deleteBoardPort.delete(loadBoard(boardKey));
    }

    private Board loadBoard(String boardKey) {
        return loadBoardPort.findById(boardKey)
                .orElseThrow(() -> new IllegalArgumentException("BOARD_NOT_FOUND"));
    }
}
