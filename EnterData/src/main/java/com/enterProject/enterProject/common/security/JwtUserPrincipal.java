package com.enterProject.enterProject.common.security;

public record JwtUserPrincipal(
        Long userId,
        String email
) {
}
