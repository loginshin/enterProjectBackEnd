package com.enterProject.enterProject.board.presentation.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BoardUpdateRequest(
        @NotBlank(message = "Title is required.")
        @Size(max = 150, message = "Title must be 150 characters or less.")
        String title,

        @NotBlank(message = "Contents are required.")
        String contents,

        @NotBlank(message = "User key is required.")
        String userKey
) {
}
