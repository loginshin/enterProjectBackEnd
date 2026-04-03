package com.enterProject.enterProject.chat.application.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateChatRoomCommand(
        @NotBlank(message = "채팅방 이름은 필수입니다.")
        String roomName,

        @NotNull(message = "생성자 ID는 필수입니다.")
        Long creatorId
) {
    public CreateChatRoomCommand(String roomName, Long creatorId) {
        this.roomName = roomName;
        this.creatorId = creatorId;
    }
}
