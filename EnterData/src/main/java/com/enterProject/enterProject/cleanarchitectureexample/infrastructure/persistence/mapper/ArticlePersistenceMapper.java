package com.enterProject.enterProject.cleanarchitectureexample.infrastructure.persistence.mapper;

import com.enterProject.enterProject.cleanarchitectureexample.domain.model.Article;
import com.enterProject.enterProject.cleanarchitectureexample.infrastructure.persistence.entity.ArticleEntity;
import org.springframework.stereotype.Component;

@Component
public class ArticlePersistenceMapper {
    public ArticleEntity toEntity(Article article) {
        return new ArticleEntity(article.id(), article.title(), article.content());
    }

    public Article toDomain(ArticleEntity entity) {
        return new Article(entity.getId(), entity.getTitle(), entity.getContent());
    }
}
