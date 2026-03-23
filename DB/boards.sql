/**
 * 게시판 데이터 관리
 */
DROP TABLE IF EXISTS boards CASCADE;

CREATE TABLE boards
(
    board_key VARCHAR(128) NOT NULL,
    board_title VARCHAR(150) NOT NULL,
    board_contents TEXT,
    create_user_key VARCHAR(128),
    create_dt TIMESTAMP,
    update_user_key VARCHAR(128),
    update_dt TIMESTAMP,
    CONSTRAINT boards_pk PRIMARY KEY (board_key)
);

COMMENT ON TABLE boards IS '게시판';
COMMENT ON COLUMN boards.board_key IS '게시판 키(UUID v7)';
COMMENT ON COLUMN boards.board_title IS '게시판 제목';
COMMENT ON COLUMN boards.board_contents IS '게시판 내용';
COMMENT ON COLUMN boards.create_user_key IS '등록자';
COMMENT ON COLUMN boards.create_dt IS '등록일';
COMMENT ON COLUMN boards.update_user_key IS '수정자';
COMMENT ON COLUMN boards.update_dt IS '수정일';
