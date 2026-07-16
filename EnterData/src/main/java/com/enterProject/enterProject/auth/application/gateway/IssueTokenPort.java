package com.enterProject.enterProject.auth.application.gateway;

import com.enterProject.enterProject.auth.application.result.TokenResult;
import com.enterProject.enterProject.auth.domain.User;

public interface IssueTokenPort {
    TokenResult issue(User user);
}
