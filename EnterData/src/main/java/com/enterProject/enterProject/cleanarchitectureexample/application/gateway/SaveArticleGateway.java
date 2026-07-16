package com.enterProject.enterProject.cleanarchitectureexample.application.gateway;

import com.enterProject.enterProject.cleanarchitectureexample.domain.model.Article;

public interface SaveArticleGateway {
    Article save(Article article);
}
