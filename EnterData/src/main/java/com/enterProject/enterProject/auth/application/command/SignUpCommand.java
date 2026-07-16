package com.enterProject.enterProject.auth.application.command;

public record SignUpCommand(
        String email,
        String password,
        String name
) {
}
