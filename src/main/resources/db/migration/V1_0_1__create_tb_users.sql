CREATE TABLE IF NOT EXISTS users
(
    id                SERIAL PRIMARY KEY,
    name              VARCHAR(100)       NOT NULL ,
    user_id           VARCHAR(50)        UNIQUE NOT NULL,
    password          VARCHAR(255)       NOT NULL,
    email             VARCHAR(100)       UNIQUE NOT NULL,
    career            VARCHAR(255),
    study_stack       VARCHAR(255),
    created_at        TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at        TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 테이블 코멘트
COMMENT ON TABLE users IS '사용자 테이블';

-- 컬럼 코멘트
COMMENT ON COLUMN users.name IS '사용자 이름';
COMMENT ON COLUMN users.user_id IS '사용자 로그인 ID (UNIQUE)';
COMMENT ON COLUMN users.password IS '사용자 비밀번호 (암호화 저장)';
COMMENT ON COLUMN users.email IS '사용자 이메일 (UNIQUE)';
COMMENT ON COLUMN users.career IS '사용자의 경력 정보';
COMMENT ON COLUMN users.study_stack IS '사용자가 공부할 기술 스택';
COMMENT ON COLUMN users.created_at IS '사용자 계정 생성 시간';
COMMENT ON COLUMN users.updated_at IS '사용자 정보 수정 시간';

