package com.enterProject.enterBoot.cleanarchitectureexample.presentation;

import com.enterProject.enterProject.cleanarchitectureexample.application.result.ArticleResult;

public record ArticleResponse(Long id, String title, String content) {
    public static ArticleResponse from(ArticleResult result) {
        return new ArticleResponse(result.id(), result.title(), result.content());
    }
}
