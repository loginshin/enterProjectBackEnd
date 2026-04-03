package com.enterProject.enterProject.chat.adapter.out.persistence.repository;

import com.enterProject.enterProject.chat.adapter.out.persistence.entity.ChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<ChatEntity, Long> {

}
