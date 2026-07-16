package com.enterProject.enterProject.cleanarchitectureexample.domain.exception;

public class ArticleNotFoundException extends IllegalArgumentException {
    public ArticleNotFoundException(Long id) {
        super("ARTICLE_NOT_FOUND: " + id);
    }
}
