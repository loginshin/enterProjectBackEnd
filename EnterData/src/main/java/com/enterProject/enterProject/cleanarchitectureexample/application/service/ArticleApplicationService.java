package com.enterProject.enterProject.cleanarchitectureexample.application.service;

import com.enterProject.enterProject.cleanarchitectureexample.application.command.*;
import com.enterProject.enterProject.cleanarchitectureexample.application.gateway.*;
import com.enterProject.enterProject.cleanarchitectureexample.application.result.ArticleResult;
import com.enterProject.enterProject.cleanarchitectureexample.application.usecase.*;
import com.enterProject.enterProject.cleanarchitectureexample.domain.exception.ArticleNotFoundException;
import com.enterProject.enterProject.cleanarchitectureexample.domain.model.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ArticleApplicationService implements CreateArticleUseCase, GetArticleUseCase, UpdateArticleUseCase, DeleteArticleUseCase {
    private final LoadArticleGateway loadArticleGateway;
    private final SaveArticleGateway saveArticleGateway;
    private final DeleteArticleGateway deleteArticleGateway;

    public ArticleResult create(CreateArticleCommand command) {
        return ArticleResult.from(saveArticleGateway.save(Article.create(command.title(), command.content())));
    }

    @Transactional(readOnly = true)
    public ArticleResult get(Long id) {
        return ArticleResult.from(load(id));
    }

    public ArticleResult update(UpdateArticleCommand command) {
        Article updated = load(command.id()).update(command.title(), command.content());
        return ArticleResult.from(saveArticleGateway.save(updated));
    }

    public void delete(Long id) {
        load(id);
        deleteArticleGateway.deleteById(id);
    }

    private Article load(Long id) {
        return loadArticleGateway.findById(id).orElseThrow(() -> new ArticleNotFoundException(id));
    }
}
