# EnterAuth 학습 및 모듈 분리 TODO

이 문서는 Enter 프로젝트의 기존 인증 코드를 공부하면서 한 단계씩 `EnterAuth`로 분리하기 위한 작업 목록이다.

현재 `EnterAuth`에는 구현 코드를 두지 않는다. 기존 인증 코드는 `EnterData`에 그대로 남겨 참고하고,
각 단계의 책임과 참조 관계를 이해한 뒤 필요한 파일만 이동한다.

## 현재 상태

- [x] 기존 인증 코드와 참조 관계 조사
- [x] 빈 `EnterAuth` 라이브러리 모듈 생성 및 `settings.gradle` 등록
- [ ] `EnterBoot -> EnterAuth -> EnterData` 의존 방향 연결
- [ ] 인증 구현 코드 이동
- [ ] 인증 테스트 이동 및 보강

## 기존 코드 위치와 목표 경계

| 기존 코드 | 최종 위치 | 이유 |
|---|---|---|
| 인증 Domain, Command, Result, UseCase, Port, Service | EnterAuth | 인증 Application/Domain 책임 |
| AuthUser Entity, Repository, Mapper, PersistenceAdapter | EnterAuth | 인증 사용자 영속 책임 |
| JWT Provider, Filter, Principal, Properties | EnterAuth | 재사용 가능한 인증 구현 |
| BCrypt Password Adapter | EnterAuth | 이메일·비밀번호 인증 구현 |
| AuthController와 HTTP Request/Response DTO | EnterBoot | HTTP 계약과 MVC 진입점 |
| SecurityConfig, SecurityFilterChain, URL 정책 | EnterBoot | 실행 애플리케이션의 접근 정책 |
| BaseEntity, SnowflakeIdGenerator | EnterData | 여러 도메인이 공유하는 기반 코드 |
| 공통 API 응답, GlobalExceptionHandler | EnterData | 애플리케이션 공통 응답/예외 계약 |

현재 프로젝트에 실제로 존재하는 기능은 회원가입, 이메일·비밀번호 로그인, Access Token 발급·검증·파싱,
Bearer 인증 필터다. Refresh Token, 로그아웃, OAuth2, 인증 쿠키, 이메일 인증, 비밀번호 초기화는 아직 없다.

## Step 1 — 모듈 의존성 이해하기

- [ ] `settings.gradle`에서 `EnterAuth` 등록 확인
- [ ] `EnterAuth/build.gradle`의 `java-library`, `bootJar=false`, `jar=true` 의미 학습
- [ ] 기존 인증 코드의 import를 보고 필요한 의존성 직접 분류
- [ ] `api`와 `implementation`의 차이를 확인하고 필요한 의존성만 추가
- [ ] `EnterBoot`가 `EnterAuth`를 의존하도록 연결
- [ ] `EnterAuth`가 `EnterBoot`를 참조하지 않는지 확인
- [ ] `:EnterAuth:compileJava` 실행

## Step 2 — 인증 Domain과 Application 이동하기

- [ ] `User`, `AuthType`, 인증 예외 이동
- [ ] `LoginCommand`, `SignUpCommand`, `TokenResult` 이동
- [ ] `LoginUseCase`, `SignUpUseCase` 이동
- [ ] Gateway를 `port.in`과 `port.out` 책임으로 분류
- [ ] `AuthService`가 Port에만 의존하는지 확인하고 이동
- [ ] 중복 이메일 오류의 범용 `IllegalArgumentException`을 전용 인증 예외로 정리
- [ ] Service 단위 테스트 작성

## Step 3 — 인증 Persistence 이동하기

- [ ] `AuthUserEntity` 이동
- [ ] `AuthUserRepository` 이동
- [ ] `AuthUserMapper` 이동
- [ ] `AuthPersistenceAdapter` 이동
- [ ] Domain과 Entity 변환이 Mapper에만 있는지 확인
- [ ] DB 테이블과 컬럼을 변경하지 않았는지 확인
- [ ] Persistence 테스트 작성

## Step 4 — 비밀번호 인증과 JWT 이동하기

- [ ] `PasswordPort`와 BCrypt Adapter 관계 이해 및 이동
- [ ] `IssueTokenPort`와 JWT Provider 관계 이해 및 이동
- [ ] `JwtProperties`를 record 기반 `@ConfigurationProperties`로 유지
- [ ] 기존 `security.jwt` property prefix 유지
- [ ] 기존 Claim `sub`, `email`, `iat`, `exp` 유지
- [ ] JWT 정상 발급·파싱 테스트
- [ ] 위변조·만료·잘못된 형식 테스트
- [ ] 라이브러리 내부 오류가 외부에 노출되지 않도록 예외 경계 정리

## Step 5 — 인증 필터와 Principal 이동하기

- [ ] `JwtUserPrincipal` 이동
- [ ] `JwtAuthenticationFilter` 이동
- [ ] 비즈니스 모듈이 JWT 구현을 직접 참조하지 않는지 확인
- [ ] 필요할 때만 최소 `AuthorizationPrincipal` 계약 추출
- [ ] 잘못된 토큰이 401 인증 실패 흐름으로 처리되는지 테스트
- [ ] 인증 주체 전달 테스트

## Step 6 — Boot 경계 정리하기

- [ ] `AuthController`를 EnterBoot로 이동
- [ ] Login/SignUp Request DTO를 EnterBoot로 이동
- [ ] Token/CurrentUser Response DTO를 EnterBoot로 이동
- [ ] `SecurityConfig`와 `SecurityFilterChain`을 EnterBoot로 이동
- [ ] 공개 URL과 보호 URL 정책 유지
- [ ] 기존 URL과 요청/응답 JSON 호환성 테스트
- [ ] 익명 접근 401과 권한 부족 403 테스트

## Step 7 — 이후 기능 확장하기

- [ ] Refresh Token 저장·회전·재사용 탐지·폐기 정책 설계
- [ ] 토큰 갱신과 로그아웃 구현
- [ ] 인증 쿠키 정책 구현
- [ ] OAuth2 사용자 정보 변환과 성공/실패 Handler 구현
- [ ] 이메일 인증 코드 처리 구현
- [ ] 비밀번호 초기화 구현

## 매 단계 검증 명령

```powershell
.\gradlew.bat :EnterAuth:compileJava
.\gradlew.bat :EnterAuth:test
.\gradlew.bat :EnterBoot:compileJava
.\gradlew.bat test
```

## 지켜야 할 경계

- Controller, CORS, URL 접근 정책, `SecurityFilterChain`은 EnterBoot에 둔다.
- EnterAuth는 EnterBoot를 의존하지 않는다.
- 비즈니스 모듈은 구체적인 JWT Provider나 Filter를 직접 의존하지 않는다.
- URL, JSON, 쿠키 이름, JWT Claim, HTTP 상태를 임의로 변경하지 않는다.
- 인증 분리를 이유로 비인증 도메인과 DB 스키마를 재설계하지 않는다.
- 기존 코드를 복사해 중복시키지 않고, 이동한 뒤 원래 파일을 제거한다.
- 새 Spring Boot Application이나 전역 `RestControllerAdvice`를 EnterAuth에 만들지 않는다.
