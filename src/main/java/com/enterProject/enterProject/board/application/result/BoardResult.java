package com.enterProject.enterProject.board.application.result;

import com.enterProject.enterProject.board.domain.Board;

import java.time.LocalDateTime;

public record BoardResult(
        String boardKey,
        String title,
        String contents,
        String createUserKey,
        LocalDateTime createAt,
        String updateUserKey,
        LocalDateTime updateAt
) {
    public static BoardResult from(Board board) {
        return new BoardResult(
                board.getBoardKey(),
                board.getTitle(),
                board.getContents(),
                board.getCreateUserKey(),
                board.getCreateAt(),
                board.getUpdateUserKey(),
                board.getUpdateAt()
        );
    }
}
