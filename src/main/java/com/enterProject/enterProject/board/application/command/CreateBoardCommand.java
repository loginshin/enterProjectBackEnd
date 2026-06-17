package com.enterProject.enterProject.board.application.command;

public record CreateBoardCommand(
        String title,
        String contents,
        String userKey
) {
}
