-- 1. 회원 (MEMBER) 테이블 생성
CREATE TABLE MEMBER (
                        member_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '회원 고유번호',
                        login_id VARCHAR(50) NOT NULL UNIQUE COMMENT '로그인 아이디',
                        password VARCHAR(255) NOT NULL COMMENT '암호화된 비밀번호',
                        name VARCHAR(50) NOT NULL COMMENT '이름',
                        nickname VARCHAR(50) NOT NULL UNIQUE COMMENT '닉네임',
                        university_email VARCHAR(100) NOT NULL UNIQUE COMMENT '대학교 이메일',
                        phone_number VARCHAR(20) COMMENT '전화번호',
                        gender VARCHAR(10) COMMENT '성별 (예: M, F)',
                        birth_date DATE NOT NULL COMMENT '생년월일',
                        preferred_food_category VARCHAR(50) COMMENT '선호 음식 카테고리',
                        profile_image_file_id BIGINT COMMENT '프로필 이미지 파일 ID (FK 대상)',
                        role VARCHAR(20) NOT NULL DEFAULT 'USER' COMMENT '권한 (USER, OWNER, ADMIN 등)',
                        account_status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE' COMMENT '계정 상태 (ACTIVE, WITHDRAWN, SUSPENDED)',
                        manner_temperature DECIMAL(5,2) NOT NULL DEFAULT 36.50 COMMENT '매너온도',
                        no_show_count INT NOT NULL DEFAULT 0 COMMENT '노쇼 횟수',
                        withdrawn_at DATETIME COMMENT '탈퇴일시',
                        created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시',
                        updated_at DATETIME COMMENT '수정일시'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 2. 이메일 인증 (EMAIL_VERIFICATION) 테이블 생성
CREATE TABLE EMAIL_VERIFICATION (
                                    verification_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '인증 고유번호',
                                    verification_email VARCHAR(100) NOT NULL COMMENT '인증 이메일',
                                    verification_code VARCHAR(20) NOT NULL COMMENT '인증 코드',
                                    verification_purpose VARCHAR(30) NOT NULL COMMENT '인증 목적 (SIGNUP, FIND_ID, RESET_PASSWORD)',
                                    expires_at DATETIME NOT NULL COMMENT '만료일시',
                                    is_verified CHAR(1) NOT NULL DEFAULT 'N' COMMENT '인증 완료 여부 (Y/N)',
                                    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
--test