package com.enterProject.enterProject.user.dto;

/**
 * 회원 가입 DTO
 */
public record UserSignUpDTO(
    String userId,
    String userName,
    String password
) {
}
