package com.enterProject.enterProject.cleanarchitectureexample.application.command;

public record UpdateArticleCommand(Long id, String title, String content) {
}
