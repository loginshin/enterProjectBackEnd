/**
 * 게시판 데이터 관리
 */
DROP TABLE IF EXISTS boards CASCADE;

CREATE TABLE boards
(
    board_id VARCHAR(36) NOT NULL,
    board_title VARCHAR(150) NOT NULL,
    board_contents TEXT,
    create_user_key VARCHAR(36),
    create_dt TIMESTAMP,
    update_user_key VARCHAR(36),
    update_dt TIMESTAMP,
    CONSTRAINT boards_pk PRIMARY KEY (board_id)
);

COMMENT ON TABLE boards IS '게시판';
COMMENT ON COLUMN boards.board_id IS '게시판 번호';
COMMENT ON COLUMN boards.board_title IS '게시판 제목';
COMMENT ON COLUMN boards.board_contents IS '게시판 내용';
COMMENT ON COLUMN boards.create_user_key IS '등록자';
COMMENT ON COLUMN boards.create_dt IS '등록일';
COMMENT ON COLUMN boards.update_user_key IS '수정자';
COMMENT ON COLUMN boards.update_dt IS '수정일';