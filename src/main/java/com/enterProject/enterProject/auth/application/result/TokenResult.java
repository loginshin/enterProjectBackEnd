package com.enterProject.enterProject.auth.application.result;

public record TokenResult(
        String tokenType,
        String accessToken,
        long expiresIn
) {
    public static TokenResult bearer(String accessToken, long expiresIn) {
        return new TokenResult("Bearer", accessToken, expiresIn);
    }
}
