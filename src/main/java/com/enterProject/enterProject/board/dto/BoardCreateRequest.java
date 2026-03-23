package com.enterProject.enterProject.board.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * ToDo : message 값 처리
 */
public record BoardCreateRequest(
        @NotBlank(message = "제목은 필수입니다.")
        @Size(max = 150, message = "제목은 150자 이내여야 합니다.")
        String title,

        @NotBlank(message = "내용은 필수입니다.")
        String contents,

        @NotBlank(message = "작성자 키는 필수입니다.")
        String userKey
) {
}
