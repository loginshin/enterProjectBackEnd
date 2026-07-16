package com.enterProject.enterProject.cleanarchitectureexample.application.gateway;

import com.enterProject.enterProject.cleanarchitectureexample.domain.model.Article;
import java.util.Optional;

public interface LoadArticleGateway {
    Optional<Article> findById(Long id);
}
