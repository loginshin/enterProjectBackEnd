# EnterAuth 모듈 분리 및 학습 TODO

`EnterAuth`는 실행 애플리케이션이 아닌 인증 라이브러리 모듈이다. 현재 의존 방향은
`EnterBoot -> EnterAuth -> EnterData`이며, `EnterAuth`가 `EnterBoot`를 참조하지 않는 것을 원칙으로 한다.

## 현재 조사 결과

| 분류 | 실제 코드 | 배치 이유 |
|---|---|---|
| Auth | Command, Result, UseCase, Port, Service, User/AuthType/인증 예외 | 인증 Application/Domain 책임 |
| Auth | AuthUser Entity/Repository/Mapper/PersistenceAdapter | 인증 사용자 영속 책임 |
| Auth | JWT Provider/Filter/Principal/Properties, BCrypt Adapter | 재사용 가능한 인증 구현 |
| Boot | AuthController와 HTTP Request/Response DTO | HTTP 계약과 MVC 진입점 |
| Boot | SecurityConfig, SecurityFilterChain, URL 접근 정책 | 실행 애플리케이션 정책 |
| Data | BaseEntity, SnowflakeIdGenerator | 여러 비즈니스 모듈이 공유하는 기반 코드 |
| Data | 공통 API 응답 및 GlobalExceptionHandler | 애플리케이션 공통 MVC 예외/응답 계약 |

현재 구현 범위는 회원가입, 이메일/비밀번호 로그인, Access Token 발급·검증·파싱,
Bearer 인증 필터다. Refresh Token, 로그아웃, OAuth2, 쿠키, 이메일 인증 및 비밀번호 초기화는 아직 구현되어 있지 않다.

## 순차 학습 및 구현 체크리스트

### 1단계 — 현재 기능의 모듈 경계 확립

- [x] 전체 모듈, 인증 파일, 설정, 테스트 구조 조사
- [x] 실제 import/Bean 참조를 기준으로 이동 대상 분류
- [x] `EnterAuth` 라이브러리 모듈 등록
- [x] 인증 Domain/Application/Persistence를 `EnterAuth`로 이동
- [x] JWT, Filter, Principal, Properties, Password Adapter를 `EnterAuth`로 이동
- [x] Controller, HTTP DTO, SecurityFilterChain을 `EnterBoot`로 이동
- [ ] 기존 회원가입·로그인·`/me` API 계약 회귀 테스트
- [x] JWT 발급, 위변조, 만료 토큰 단위 테스트
- [x] 인증 없음(401) Security 테스트
- [ ] 권한 부족(403) Security 테스트(역할별 보호 API 도입 시 구체화)

### 2단계 — 현재 코드의 헥사고날 구조 정돈

- [ ] `application.gateway`를 `port.in`/`port.out`으로 명확히 분리
- [ ] `application.result`를 `application.response`로 정리
- [ ] persistence 패키지를 `adapter.out.persistence`로 정리
- [ ] 서비스와 어댑터의 공개 범위를 Bean 프록시/테스트 조건 안에서 최소화
- [ ] 중복 이메일과 이메일 형식 오류를 기존 공통 예외 계층에 맞는 전용 인증 예외로 통일
- [ ] JWT 라이브러리 내부 오류가 외부 응답에 노출되지 않는지 검증
- [ ] `AuthorizationPrincipal` 같은 최소 공통 계약이 실제 비즈니스 모듈에 필요한지 참조 발생 시 결정

### 3단계 — Refresh Token과 세션 수명주기

- [ ] Refresh Token Command/Response/UseCase/Port 설계
- [ ] Refresh Token Entity/Repository/Mapper/Adapter 구현
- [ ] 발급·회전(rotation)·재사용 탐지·폐기 정책 결정 및 테스트
- [ ] 토큰 갱신과 로그아웃 API를 Boot Controller에 추가
- [ ] 기존 Access Token claim(`sub`, `email`, `iat`, `exp`)과 응답 계약 유지

### 4단계 — 쿠키 및 OAuth2

- [ ] 인증 쿠키의 이름, Path, Domain, SameSite, Secure, HttpOnly 정책을 설정 속성으로 정의
- [ ] OAuth2 Authorization Request 저장소 구현
- [ ] 공급자별 사용자 정보 변환과 계정 연결 Port 구현
- [ ] OAuth2 성공/실패 Handler 구현 및 응답 계약 테스트
- [ ] OAuth2 Controller/URL 정책은 Boot에 유지

### 5단계 — 이메일 인증과 계정 복구

- [ ] 인증 코드 생성·저장·만료·시도 제한 Port 구현
- [ ] 회원가입 이메일 인증 흐름 구현
- [ ] 비밀번호 초기화 Command/UseCase 및 이메일 발송 Port 구현
- [ ] 코드 재사용, 만료, 무차별 대입 방지 테스트

### 6단계 — 설정과 운영 검증

- [ ] JWT/Refresh/OAuth2/Cookie/Email 설정을 record 기반 `@ConfigurationProperties`로 구성
- [ ] 기존 `security.jwt` prefix와 환경별 값을 유지
- [ ] 필요 시 보안 YAML을 별도 config 디렉터리에서 `processResources`로 공급
- [ ] `EnterBoot`의 `@ConfigurationPropertiesScan` 또는 명시적 등록 방식 검증
- [ ] 모듈 의존성 보고서로 순환 의존성 없음 확인
- [ ] `:EnterAuth:test`, `:EnterBoot:test`, 전체 `test`를 CI에 등록

## 변경 시 지켜야 할 계약

- Controller, CORS, URL 인가 정책, `SecurityFilterChain`은 Boot에 둔다.
- Auth는 Boot를 의존하지 않는다.
- 비즈니스 모듈은 구체적인 JWT Provider나 Filter를 참조하지 않는다.
- URL, 요청/응답 JSON, 쿠키 이름, JWT claim과 상태 코드는 명시적 마이그레이션 없이 변경하지 않는다.
- 인증 분리를 이유로 비인증 도메인이나 DB 스키마를 재설계하지 않는다.
- 필터 예외는 Spring Security의 인증/인가 실패 처리 흐름으로 전달하고 새 전역 Advice를 만들지 않는다.

## 단계별 검증 명령

```powershell
.\gradlew.bat :EnterAuth:compileJava
.\gradlew.bat :EnterAuth:test
.\gradlew.bat :EnterBoot:compileJava
.\gradlew.bat :EnterBoot:test
.\gradlew.bat test
```
