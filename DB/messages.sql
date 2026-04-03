/* =========================================================
messages
========================================================= */
DROP TABLE IF EXISTS messages;

CREATE TABLE messages (
    message_id BIGINT NOT NULL COMMENT '메시지번호',
    room_id BIGINT NOT NULL COMMENT '채팅방번호',
    sender_type ENUM('USER','AI') NOT NULL COMMENT '보낸이',
    content TEXT NOT NULL COMMENT '내용',
    created_at DATETIME NOT NULL COMMENT '생성 시간(UTC-0)',

    PRIMARY KEY (message_id),
    CONSTRAINT fk_messages_room
      FOREIGN KEY (room_id) REFERENCES chat_rooms(room_id)
) COMMENT='메시지';

CREATE INDEX idx_messages_room_id_created_at
    ON messages(room_id, created_at);