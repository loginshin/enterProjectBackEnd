# EnterProject Backend

SpringBoot, Kotlin, JPA, QueryDSL, PostgreSQL을 활용한 스터디 및 테스트 프로젝트입니다.

## 라이브러리
- Snowflake
- mapstruct

### 인프라 실행 (Postgres + Redis) docker Compose
```
docker-compose up -d postgres redis
```

### ERD

ErdCloud : [ErdCloudLink](https://www.erdcloud.com/d/eyufagNWWetgSo2FA)

-----

✅ 게시글 고유 키 변경 (Long -> UUID v7 -> SnowFlake)
- **변경 이유**: 
  - 외부 노출 시 게시글 순서 유추 방지
  - 분산 DB 환경에서의 ID 충돌 방지 및 고유성 보장
  - 데이터 용량 변화로 속도 개선
- **적용 방식**:
  - ~~`uuid-creator` 라이브러리를 활용하여 `@PrePersist` 단계에서 자동 생성~~
  - Service Layer에서 직접 SnowFlake 구현

✅ 초기 스크립트 관리
 - 초기 스크립트를 관리하여 안정성을 확보하고 서버 이전, 온프레미스에도 이점을 얻어간다.

✅ 전역 예외 처리 Global ExceptionHandler 후 테스트

✅ JPA 적용

✅ response 응답 유틸 구현

global Exception handler

restControllerAdvice

Response Entity, Response DTO 활용


i18n 다국어 지원 구현 (msg 컨트롤)

OAuth 카카오톡, 구글 연동 로그인

토큰기반 로그인 관리 + 세션 기반 클라이언트 런타임 관리 구현
시큐리티 적용
- usernamePassword 검증
- Security Filter Chain
- jwt access + refresh생성
- jwt Filter (진입부 인증)
- 응답 or 쿠키 세팅
- security 예외처리

전역 로깅



board List 구현

프론트 간단 구현 후 백엔드 전체 직접 테스트


---

---

---


# 컨벤션 (개인규칙)

### 아키텍처 및 구조

- 헥사고널 아키텍처 구조를 갖습니다.

### DB

테이블 명명은 도메인에 s를 붙여 tables 로 지정합니다.

### DTO / Mapper

- Mapper(mapstruct)는 Domain ↔ Entity 변환에만 사용한다. DTO → Command, Command → Domain은 Mapper가 아닌 직접 생성으로 처리한다.
  - DTO → Commend Mapper
  - Commend → Domain Mapper
  - 는 과 설계로 판단하여 직접 생성하도록

### 파일 네이밍

- User**DTO**
- User (Domain)
- User**Command**
- User**Mapper**
- User**Entity**
- User**Controller**
- User**Service**
- User**Repository**
- User**CustomRepository**
- User**RepositoryImpl**
- 와 같이 파일의 목적을 명시해주세요.

### Repository

- Repository는 JPA Repository, CustomRepository ↔ RepositoryImpl(QueryDSL로 CustomRepository를 구현)로 구성됩니다.



ExceptionHendler

### Return