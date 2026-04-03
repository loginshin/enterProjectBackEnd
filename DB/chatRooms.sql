/* =========================================================
chat_rooms
========================================================= */
DROP TABLE IF EXISTS chat_rooms;

CREATE TABLE chat_rooms (
    room_id BIGINT NOT NULL COMMENT '채팅방번호',
    user_id BIGINT NOT NULL COMMENT '유저번호',
    character_id BIGINT NOT NULL COMMENT '캐릭터번호',
    persona_id BIGINT NULL COMMENT '페르소나번호',
    room_uid CHAR(36) NOT NULL COMMENT '채팅방고유번호',
    room_name VARCHAR(30) NOT NULL COMMENT '이름',
    memory TEXT NULL COMMENT '장기기억',
    user_note TEXT NULL COMMENT '유저노트',
    language VARCHAR(10) NOT NULL COMMENT '언어',
    last_message_at DATETIME NULL COMMENT '마지막메시지시간',
    total_turn_count INT NOT NULL DEFAULT 0 COMMENT '채팅수',
    created_at DATETIME NOT NULL COMMENT '생성 시간(UTC-0)',
    updated_at DATETIME NOT NULL COMMENT '수정 시간(UTC-0)',

    PRIMARY KEY (room_id),
    CONSTRAINT uk_chat_rooms_room_uid UNIQUE (room_uid)
) COMMENT='채팅방';

CREATE INDEX idx_chat_rooms_user_id
    ON chat_rooms(user_id);

CREATE INDEX idx_chat_rooms_character_id
    ON chat_rooms(character_id);

CREATE INDEX idx_chat_rooms_last_message_at
    ON chat_rooms(last_message_at);