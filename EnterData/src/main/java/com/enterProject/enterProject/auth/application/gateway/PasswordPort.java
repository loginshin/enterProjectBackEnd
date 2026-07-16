package com.enterProject.enterProject.auth.application.gateway;

public interface PasswordPort {
    String encode(String rawPassword);

    boolean matches(String rawPassword, String encodedPassword);
}
