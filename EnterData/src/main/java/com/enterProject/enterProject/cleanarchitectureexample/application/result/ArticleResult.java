package com.enterProject.enterProject.cleanarchitectureexample.application.result;

import com.enterProject.enterProject.cleanarchitectureexample.domain.model.Article;

public record ArticleResult(Long id, String title, String content) {
    public static ArticleResult from(Article article) {
        return new ArticleResult(article.id(), article.title(), article.content());
    }
}
