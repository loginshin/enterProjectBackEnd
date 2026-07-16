package com.enterProject.enterProject.chat.application.service;

import com.enterProject.enterProject.chat.application.command.CreateChatRoomCommand;
import com.enterProject.enterProject.chat.application.usecase.CreateChatRoomUseCase;
import com.enterProject.enterProject.chat.application.gateway.SaveChatRoomPort;
import com.enterProject.enterProject.chat.domain.ChatRoom;
import com.enterProject.enterProject.common.utill.SnowflakeIdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ChatRoomService implements CreateChatRoomUseCase {

    private final SaveChatRoomPort saveChatRoomPort;
    private final SnowflakeIdGenerator idGenerator;

    @Override
    public void createChatRoom(CreateChatRoomCommand command) {
        // Snowflake濡?ID ?앹꽦
        Long roomId = idGenerator.nextId();
        
        // ?꾨찓??紐⑤뜽 ?앹꽦
        ChatRoom chatRoom = ChatRoom.create(roomId, command.roomName(), command.creatorId());
        
        // ????ы듃 ?몄텧
        saveChatRoomPort.saveChatRoom(chatRoom);
    }
}
