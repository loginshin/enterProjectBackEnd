package com.enterProject.enterProject.chat.adapter.in.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatRoomCreateRequest {
    @NotBlank(message = "채팅방 이름을 입력해주세요.")
    private String roomName;

    @NotNull(message = "사용자 ID가 누락되었습니다.")
    private Long creatorId;
}
