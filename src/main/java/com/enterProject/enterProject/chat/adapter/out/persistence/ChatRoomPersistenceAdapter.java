package com.enterProject.enterProject.chat.adapter.out.persistence;

import com.enterProject.enterProject.chat.adapter.out.persistence.entity.ChatRoomEntity;
import com.enterProject.enterProject.chat.adapter.out.persistence.mapper.ChatRoomMapper;
import com.enterProject.enterProject.chat.adapter.out.persistence.repository.ChatRoomRepository;
import com.enterProject.enterProject.chat.application.port.out.SaveChatRoomPort;
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
