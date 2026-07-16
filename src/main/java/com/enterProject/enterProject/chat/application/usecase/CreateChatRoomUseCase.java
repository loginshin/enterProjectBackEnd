package com.enterProject.enterProject.chat.application.usecase;

import com.enterProject.enterProject.chat.application.command.CreateChatRoomCommand;

public interface CreateChatRoomUseCase {
    void createChatRoom(CreateChatRoomCommand command);
}

