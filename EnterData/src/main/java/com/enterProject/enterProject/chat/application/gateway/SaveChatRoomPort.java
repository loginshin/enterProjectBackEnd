package com.enterProject.enterProject.chat.application.gateway;

import com.enterProject.enterProject.chat.domain.ChatRoom;

public interface SaveChatRoomPort {
    void saveChatRoom(ChatRoom chatRoom);
}
