package com.enterProject.enterBoot.cleanarchitectureexample.presentation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ArticleUpdateRequest(
        @NotBlank(message = "ARTICLE_TITLE_REQUIRED") @Size(max = 100) String title,
        @NotBlank(message = "ARTICLE_CONTENT_REQUIRED") String content
) {
}
