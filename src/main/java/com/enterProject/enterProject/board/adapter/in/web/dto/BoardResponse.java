package com.enterProject.enterProject.board.adapter.in.web.dto;

import com.enterProject.enterProject.board.application.result.BoardResult;

import java.time.LocalDateTime;

public record BoardResponse(
        String boardKey,
        String title,
        String contents,
        String createUserKey,
        LocalDateTime createAt,
        String updateUserKey,
        LocalDateTime updateAt
) {
    public static BoardResponse from(BoardResult result) {
        return new BoardResponse(
                result.boardKey(),
                result.title(),
                result.contents(),
                result.createUserKey(),
                result.createAt(),
                result.updateUserKey(),
                result.updateAt()
        );
    }
}
