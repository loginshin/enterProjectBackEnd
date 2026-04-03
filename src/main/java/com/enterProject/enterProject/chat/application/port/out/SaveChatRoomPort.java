package com.enterProject.enterProject.chat.application.port.out;

import com.enterProject.enterProject.chat.domain.ChatRoom;

public interface SaveChatRoomPort {
    void saveChatRoom(ChatRoom chatRoom);
}
