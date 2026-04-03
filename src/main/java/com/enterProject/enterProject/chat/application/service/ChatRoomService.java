package com.enterProject.enterProject.chat.application.service;

import com.enterProject.enterProject.chat.application.command.CreateChatRoomCommand;
import com.enterProject.enterProject.chat.application.port.in.CreateChatRoomUseCase;
import com.enterProject.enterProject.chat.application.port.out.SaveChatRoomPort;
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
        // Snowflake로 ID 생성
        Long roomId = idGenerator.nextId();
        
        // 도메인 모델 생성
        ChatRoom chatRoom = ChatRoom.create(roomId, command.roomName(), command.creatorId());
        
        // 저장 포트 호출
        saveChatRoomPort.saveChatRoom(chatRoom);
    }
}
