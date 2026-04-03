package com.enterProject.enterProject.chat.application.port.in;

import com.enterProject.enterProject.chat.application.command.CreateChatRoomCommand;

public interface CreateChatRoomUseCase {
    void createChatRoom(CreateChatRoomCommand command);
}

