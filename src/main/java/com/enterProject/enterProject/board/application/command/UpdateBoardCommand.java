package com.enterProject.enterProject.board.application.command;

public record UpdateBoardCommand(
        String boardKey,
        String title,
        String contents,
        String userKey
) {
}
