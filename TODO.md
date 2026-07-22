# EnterProject 전체 TODO

프로젝트 전반의 큰 작업을 한곳에서 확인하기 위한 인덱스다. 각 항목의 링크를 열어 세부 체크리스트와 대상 파일을 확인한다.

## 인증 모듈 구현 및 분리

- [ ] 기존 인증 구현을 `EnterAuth` 라이브러리 모듈로 이동하고 모듈 경계를 정리한다.
- [ ] `EnterBoot -> EnterAuth -> EnterData` 의존 방향을 구성한다.
- [ ] 인증 단위·통합 테스트를 이동하고 보강한다.
- 상세 TODO: [EnterAuth 학습 및 모듈 분리 TODO](EnterAuth/README.md)
- 현재 구현 위치: [EnterData auth 패키지](EnterData/src/main/java/com/enterProject/enterProject/auth/)
- 이동 대상 모듈: [EnterAuth 모듈](EnterAuth/)

## 파일 저장 구현

- [ ] 파일 메타데이터와 실제 바이너리 저장소를 분리한다.
- [ ] 로컬 및 AWS S3 저장 Adapter와 파일 상태 전이·정리 기능을 구현한다.
- [ ] 저장, 소유권, 롤백 보상, purge 동시성 테스트를 작성한다.
- 상세 TODO: [파일 저장 구현 TODO](EnterData/src/main/java/com/enterProject/enterProject/file/fileTodo.md)
- 구현 대상 위치: [file 패키지](EnterData/src/main/java/com/enterProject/enterProject/file/)

## 공통 Annotation 만들기

- [ ] 반복되는 검증, 권한 확인, 로깅 또는 멱등성 처리 중 Annotation으로 분리할 대상을 조사한다.
- [ ] Annotation의 적용 대상(`TYPE`, `METHOD`, `PARAMETER`, `FIELD`)과 유지 범위(`RUNTIME` 등)를 명확히 정한다.
- [ ] 공통 Annotation 패키지와 이름 규칙을 정한다.
- [ ] 필요한 경우 AOP, ArgumentResolver 또는 Validator 기반 처리기를 구현한다.
- [ ] 잘못된 적용 위치와 누락된 필수 값에 대한 예외 정책을 정의한다.
- [ ] Annotation 단위 테스트와 실제 Controller/Service 적용 통합 테스트를 작성한다.
- 후보 위치: [common 패키지](EnterData/src/main/java/com/enterProject/enterProject/common/)

## Snowflake ID를 라이브러리로 분리

- [ ] Snowflake 구현과 사용처를 조사하고 라이브러리의 공개 API를 정한다.
- [ ] 재사용 가능한 별도 Gradle 라이브러리 모듈(예: `EnterSnowflake`)을 만든다.
- [ ] worker ID, datacenter ID, epoch를 외부 설정으로 주입할 수 있게 한다.
- [ ] 동일 밀리초의 sequence 처리, 시계 역행, ID 중복 방지 정책을 정의한다.
- [ ] 동시성, 경계값, 시계 역행 및 중복 방지 테스트를 작성한다.
- [ ] `EnterData`의 직접 구현을 새 라이브러리 의존으로 교체하고 기존 파일을 제거한다.
- 현재 구현: [Snowflake.java](EnterData/src/main/java/com/enterProject/enterProject/common/utill/Snowflake.java)
- 현재 Adapter: [SnowflakeIdGenerator.java](EnterData/src/main/java/com/enterProject/enterProject/common/utill/SnowflakeIdGenerator.java)

## Swagger 도입 및 API 명세 정리

- [ ] Swagger(OpenAPI) 라이브러리를 도입하고 각 모듈의 설정을 구성한다.
- [ ] 애플리케이션 진입점에서 Swagger Docs에 접근할 수 있도록 경로와 보안 예외를 설정한다.
- [ ] Controller의 요청·응답, 상태 코드, 인증 방식 및 오류 응답을 Swagger Docs 명세로 정리한다.
- [ ] 실행 환경별 Swagger Docs 공개 범위를 정하고 정상적으로 조회되는지 확인한다.

## DB 사용자 삭제 Function 구현 및 연동

- [ ] DB에 사용자와 연관 데이터를 정책에 맞게 삭제하는 사용자 삭제 Function을 만든다.
- [ ] 삭제 순서, 외래 키, 트랜잭션 및 실패 시 롤백 정책을 정의한다.
- [ ] 서버에서 사용자 삭제 Function을 호출하는 로직을 구현한다.
- [ ] 서버를 통해 실제 사용자 삭제를 호출하고 연관 데이터 처리 결과를 검증한다.
- [ ] 정상 삭제, 존재하지 않는 사용자, 중복 호출 및 실패 롤백 테스트를 작성한다.

## 완료 기준

- [ ] 변경한 각 모듈의 테스트를 통과한다.
- [ ] 전체 `gradlew.bat test`를 통과한다.
- [ ] 모듈 의존 방향과 공개 API를 문서에 반영한다.
- [ ] 완료된 세부 TODO와 이 문서의 체크 상태를 함께 갱신한다.
