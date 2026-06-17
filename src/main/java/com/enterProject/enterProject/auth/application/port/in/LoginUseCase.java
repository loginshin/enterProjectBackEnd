package com.enterProject.enterProject.auth.application.port.in;

import com.enterProject.enterProject.auth.application.command.LoginCommand;
import com.enterProject.enterProject.auth.application.result.TokenResult;

public interface LoginUseCase {
    TokenResult login(LoginCommand command);
}
