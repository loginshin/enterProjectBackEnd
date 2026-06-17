package com.enterProject.enterProject.auth.adapter.in.web.dto;

import com.enterProject.enterProject.common.security.JwtUserPrincipal;

public record CurrentUserResponseDTO(
        Long userId,
        String email
) {
    public static CurrentUserResponseDTO from(JwtUserPrincipal principal) {
        return new CurrentUserResponseDTO(principal.userId(), principal.email());
    }
}
