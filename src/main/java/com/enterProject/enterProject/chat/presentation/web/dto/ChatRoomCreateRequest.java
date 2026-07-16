package com.enterProject.enterProject.chat.presentation.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatRoomCreateRequest {
    @NotBlank(message = "梨꾪똿諛??대쫫???낅젰?댁＜?몄슂.")
    private String roomName;

    @NotNull(message = "?ъ슜??ID媛 ?꾨씫?섏뿀?듬땲??")
    private Long creatorId;
}
