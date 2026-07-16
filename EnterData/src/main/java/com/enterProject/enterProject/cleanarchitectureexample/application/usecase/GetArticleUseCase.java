package com.enterProject.enterProject.cleanarchitectureexample.application.usecase;

import com.enterProject.enterProject.cleanarchitectureexample.application.result.ArticleResult;

public interface GetArticleUseCase {
    ArticleResult get(Long id);
}
