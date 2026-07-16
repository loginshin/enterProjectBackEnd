package com.enterProject.enterProject.chat.presentation.web.controller;

import com.enterProject.enterProject.chat.presentation.web.dto.ChatRoomCreateRequest;
import com.enterProject.enterProject.chat.application.command.CreateChatRoomCommand;
import com.enterProject.enterProject.chat.application.usecase.CreateChatRoomUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/chat")
@RequiredArgsConstructor
public class ChatController {

    private final CreateChatRoomUseCase createChatRoomUseCase;

    @PostMapping("/rooms")
    public void createChatRoom(@RequestBody @Valid ChatRoomCreateRequest request) {
        // DTO -> Command 蹂??(?대뙌?곗쓽 ??븷)
        createChatRoomUseCase.createChatRoom(
                new CreateChatRoomCommand(request.getRoomName(), request.getCreatorId())
        );
    }
}
