/* =========================================================
authentications
========================================================= */
DROP TABLE IF EXISTS authentications;

CREATE TABLE authentications (
    auth_id BIGINT NOT NULL COMMENT '인증 고유 ID',
    user_id BIGINT NOT NULL COMMENT '사용자 ID',
    auth_type VARCHAR(50) NOT NULL COMMENT '인증 타입',
    provider VARCHAR(50) NULL COMMENT '소셜 제공자',
    provider_id VARCHAR(100) NULL COMMENT '소셜 고유 ID',
    email VARCHAR(255) NULL COMMENT '이메일',
    password VARCHAR(255) NULL COMMENT '비밀번호 (bcrypt 암호화)',
    last_login_at DATETIME NULL COMMENT '마지막 로그인 시간 (UTC-0)',
    created_at DATETIME NOT NULL COMMENT '생성 시간 (UTC-0)',
    updated_at DATETIME NOT NULL COMMENT '수정 시간 (UTC-0)',
    PRIMARY KEY (auth_id),
    CONSTRAINT fk_auth_user
     FOREIGN KEY (user_id)
         REFERENCES users(user_id)
         ON DELETE CASCADE,
    UNIQUE KEY uk_provider (provider, provider_id),
    UNIQUE KEY uk_email (email)
) COMMENT = '인증';

INSERT INTO authentications ( auth_id, user_id, auth_type, email, password, created_at, updated_at
) VALUES ( 333, 333, 'LOCAL', 'admin@plat.com', '1234', UTC_TIMESTAMP(), UTC_TIMESTAMP());