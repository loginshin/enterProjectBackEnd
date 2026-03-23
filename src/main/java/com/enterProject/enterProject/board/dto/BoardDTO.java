package com.enterProject.enterProject.board.dto;

import java.time.LocalDateTime;

public record BoardDTO(
        Long boardKey,
        String boardTitle,
        String boardContents,
        String createUserKey,
        LocalDateTime createDt,
        String updateUserKey,
        LocalDateTime updateDt
) {
}
