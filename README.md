# EnterProject Backend

SpringBoot, Kotlin, JPA, QueryDSL, PostgreSQL을 활용한 스터디 및 테스트 프로젝트입니다.

## 라이브러리
- Snowflake
- mapstruct

-----

✅ 게시글 고유 키 변경 (Long -> UUID v7)
- **변경 이유**: 
  - 외부 노출 시 게시글 순서 유추 방지 (보안성 강화)
  - 분산 DB 환경에서의 ID 충돌 방지 및 고유성 보장
- **적용 방식**:
  - **UUID v7** (Time-ordered Epoch) 적용:
    - 상위 48비트에 타임스탬프를 포함하여 생성 순서대로 정렬 가능 (Index 성능 최적화)
    - 무작위성과 순차성을 동시에 확보하여 암호화된 느낌의 ID를 순차적으로 부여 가능
  - `uuid-creator` 라이브러리를 활용하여 `@PrePersist` 단계에서 자동 생성

✅ 초기 스크립트 관리
 - 초기 스크립트를 관리하여 안정성을 확보하고 서버 이전, 온프레미스에도 이점을 얻어간다.

✅ 전역 예외 처리 Global ExceptionHandler 후 테스트

✅ JPA 적용

✅ response 응답 유틸 구현

토큰기반 로그인 관리 + 세션 기반 클라이언트 런타임 관리 구현

i18n 다국어 지원

OAuth 카카오톡, 구글 연동 로그인

board List 구현

프론트 간단 구현 후 백엔드 전체 직접 테스트



# 컨벤션 (개인규칙)

### 아키텍처 및 구조

- 헥사고널 아키텍처 구조를 갖습니다.
- 헥사고널 구조에서 [adapter.in](http://adapter.in) 은 내부 진입점이기 때문에 plat-boot에 도메인 별로 패키지를 두고 DTO,Controller를 둡니다.

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