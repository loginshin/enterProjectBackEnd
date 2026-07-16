package com.enterProject.enterProject.chat.infrastructure.persistence;

import com.enterProject.enterProject.chat.infrastructure.persistence.entity.ChatRoomEntity;
import com.enterProject.enterProject.chat.infrastructure.persistence.mapper.ChatRoomMapper;
import com.enterProject.enterProject.chat.infrastructure.persistence.repository.ChatRoomRepository;
import com.enterProject.enterProject.chat.application.gateway.SaveChatRoomPort;
import com.enterProject.enterProject.chat.domain.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChatRoomPersistenceAdapter implements SaveChatRoomPort {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatRoomMapper chatRoomMapper;

    @Override
    public void saveChatRoom(ChatRoom chatRoom) {
        ChatRoomEntity entity = chatRoomMapper.toEntity(chatRoom);
        chatRoomRepository.save(entity);
    }
}
