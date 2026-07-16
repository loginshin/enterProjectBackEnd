package com.enterProject.enterProject.cleanarchitectureexample.application.usecase;

import com.enterProject.enterProject.cleanarchitectureexample.application.command.UpdateArticleCommand;
import com.enterProject.enterProject.cleanarchitectureexample.application.result.ArticleResult;

public interface UpdateArticleUseCase {
    ArticleResult update(UpdateArticleCommand command);
}
