package com.enterProject.enterProject.chat.adapter.out.persistence.mapper;

import com.enterProject.enterProject.chat.adapter.out.persistence.entity.ChatRoomEntity;
import com.enterProject.enterProject.chat.domain.ChatRoom;
import org.springframework.stereotype.Component;

@Component
public class ChatRoomMapper {
    public ChatRoomEntity toEntity(ChatRoom chatRoom) {
        return ChatRoomEntity.builder()
                .id(chatRoom.getId())
                .roomName(chatRoom.getName())
                .creatorId(chatRoom.getCreatorId())
                .build();
    }

    public ChatRoom toDomain(ChatRoomEntity entity) {
        return ChatRoom.builder()
                .id(entity.getId())
                .name(entity.getRoomName())
                .creatorId(entity.getCreatorId())
                .build();
    }
}
