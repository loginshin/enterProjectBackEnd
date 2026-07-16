package com.enterProject.enterProject.cleanarchitectureexample.infrastructure.persistence;

import com.enterProject.enterProject.cleanarchitectureexample.application.gateway.*;
import com.enterProject.enterProject.cleanarchitectureexample.domain.model.Article;
import com.enterProject.enterProject.cleanarchitectureexample.infrastructure.persistence.mapper.ArticlePersistenceMapper;
import com.enterProject.enterProject.cleanarchitectureexample.infrastructure.persistence.repository.ArticleJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ArticlePersistenceAdapter implements LoadArticleGateway, SaveArticleGateway, DeleteArticleGateway {
    private final ArticleJpaRepository repository;
    private final ArticlePersistenceMapper mapper;

    public Optional<Article> findById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    public Article save(Article article) {
        return mapper.toDomain(repository.save(mapper.toEntity(article)));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
