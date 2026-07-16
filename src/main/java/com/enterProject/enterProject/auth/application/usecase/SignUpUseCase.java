package com.enterProject.enterProject.auth.application.usecase;

import com.enterProject.enterProject.auth.application.command.SignUpCommand;

public interface SignUpUseCase {
    void signUp(SignUpCommand command);
}
