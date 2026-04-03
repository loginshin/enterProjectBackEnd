package com.enterProject.enterProject.chat.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ChatRoom {
    private final Long id;
    private final String name;
    private final Long creatorId;

    public static ChatRoom create(Long id, String name, Long creatorId) {
        // 비즈니스 검증 로직 추가 가능
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("채팅방 이름은 필수입니다.");
        }
        return new ChatRoom(id, name, creatorId);
    }
}
