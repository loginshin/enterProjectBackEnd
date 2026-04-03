package com.enterProject.enterProject.auth.application.port.out;

import com.enterProject.enterProject.auth.domain.User;

public interface SaveUserPort {
    void saveUser(User user);
}
