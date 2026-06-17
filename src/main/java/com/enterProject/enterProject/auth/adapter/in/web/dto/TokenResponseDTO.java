package com.enterProject.enterProject.auth.adapter.in.web.dto;

import com.enterProject.enterProject.auth.application.result.TokenResult;

public record TokenResponseDTO(
        String tokenType,
        String accessToken,
        long expiresIn
) {
    public static TokenResponseDTO from(TokenResult result) {
        return new TokenResponseDTO(result.tokenType(), result.accessToken(), result.expiresIn());
    }
}
