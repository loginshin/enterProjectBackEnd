package com.enterProject.enterProject.chat.adapter.out.persistence.repository;

import com.enterProject.enterProject.chat.adapter.out.persistence.entity.ChatRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity, Long> {
}
