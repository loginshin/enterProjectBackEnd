package com.enterProject.enterProject.chat.infrastructure.persistence.repository;

import com.enterProject.enterProject.chat.infrastructure.persistence.entity.ChatRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity, Long> {
}
