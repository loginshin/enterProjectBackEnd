package com.enterProject.enterProject.cleanarchitectureexample.application.usecase;

import com.enterProject.enterProject.cleanarchitectureexample.application.command.CreateArticleCommand;
import com.enterProject.enterProject.cleanarchitectureexample.application.result.ArticleResult;

public interface CreateArticleUseCase {
    ArticleResult create(CreateArticleCommand command);
}
