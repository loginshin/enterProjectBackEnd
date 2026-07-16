package com.enterProject.enterProject.cleanarchitectureexample.domain.model;

public record Article(Long id, String title, String content) {
    public static Article create(String title, String content) {
        validate(title, content);
        return new Article(null, title.trim(), content.trim());
    }

    public Article update(String title, String content) {
        validate(title, content);
        return new Article(id, title.trim(), content.trim());
    }

    private static void validate(String title, String content) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("ARTICLE_TITLE_REQUIRED");
        if (title.trim().length() > 100) throw new IllegalArgumentException("ARTICLE_TITLE_TOO_LONG");
        if (content == null || content.isBlank()) throw new IllegalArgumentException("ARTICLE_CONTENT_REQUIRED");
    }
}
