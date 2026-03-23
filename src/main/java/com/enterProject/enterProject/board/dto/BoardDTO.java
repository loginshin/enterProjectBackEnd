package com.enterProject.enterProject.board.dto;

import java.time.LocalDateTime;

public record BoardDTO(
        String boardKey,
        String boardTitle,
        String boardContents,
        String createUserKey,
        LocalDateTime createDt,
        String updateUserKey,
        LocalDateTime updateDt
) {
}
