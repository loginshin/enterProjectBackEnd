package com.enterProject.enterProject.user.dto;

/**
 * 사용자 정보 DTO
 */
public record UserDTO(
    String userKey,
    String userId,
    String userName,
    String email
) {
}
