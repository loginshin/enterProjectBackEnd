# 아키텍처 정리

## 헥사고널 아키텍처

헥사고널 아키텍처의 핵심은 업무 규칙을 HTTP, JPA 같은 외부 기술에서 분리하는 것이다.
애플리케이션 안쪽은 필요한 기능을 포트(interface)로 정의하고, 바깥쪽의 어댑터가 그
포트를 구현하거나 호출한다.

이 예제의 요청 흐름은 다음과 같다.

```text
HTTP 요청
  -> EnterBoot: adapter/in/web/HexagonalController
  -> application/port/in/HexagonalUseCase
  -> application/service/HexagonalService
  -> application/port/out/HexagonalPersistencePort
  -> adapter/out/persistence/HexagonalPersistenceAdapter
  -> repository/HexagonalJpaRepository
```

패키지별 역할:

- `domain`: 프레임워크를 모르는 도메인 모델과 규칙
- `application/port/in`: 외부에서 실행할 수 있는 기능
- `application/port/out`: 애플리케이션이 외부 시스템에 요구하는 기능
- `application/service`: 유스케이스의 실행 순서와 트랜잭션
- `adapter/in`: HTTP, 메시지처럼 애플리케이션으로 들어오는 연결부. 이 예제에서는
  실행 경계인 `EnterBoot`에 둔다.
- `adapter/out`: DB, 외부 API처럼 애플리케이션 밖으로 나가는 연결부

장점:

- DB나 외부 API가 바뀌어도 업무 규칙에 미치는 영향이 작다.
- 포트를 기준으로 책임이 나뉘어 의존 관계가 눈에 보인다.
- 외부 시스템을 대체한 단위 테스트를 작성하기 쉽다.

단점:

- 기능이 작아도 포트와 어댑터 파일이 추가된다.
- 기준 없이 적용하면 이름만 다른 인터페이스가 늘어난다.
- 단순 CRUD에서는 구조가 주는 이점보다 코드량이 더 커질 수 있다.

DB, 메시지 브로커, 외부 API처럼 교체 가능성이 있는 연결이 많거나 핵심 업무 규칙을
오래 유지해야 하는 도메인에 적합하다.

## 레이어드 아키텍처

레이어드 아키텍처는 기술적 역할에 따라 코드를 위에서 아래로 나눈다.

```text
Controller -> Service -> Repository -> Database
```

구조가 익숙하고 흐름이 단순해서 일반적인 CRUD 서비스에 잘 맞는다. 개발 속도가 빠르고
새 구성원이 이해하기도 쉽다. 반면 Service가 Repository와 JPA Entity에 직접 의존하기
시작하면 업무 규칙과 저장 기술이 쉽게 엉킨다. 규모가 커질수록 Service가 여러 책임을
떠안는 문제도 자주 생긴다.

변경이 적고 CRUD 비중이 높은 관리 기능이나 작은 서비스라면 가장 실용적인 선택이다.

## 클린 아키텍처

클린 아키텍처는 코드를 원형 계층으로 보고 의존성이 항상 안쪽을 향하게 한다.

```text
Frameworks -> Interface Adapters -> Application -> Domain
```

안쪽의 Domain과 Application은 웹, DB, 프레임워크를 알지 않는다. 바깥 계층은 안쪽
계층을 사용할 수 있지만 반대 방향의 참조는 허용하지 않는다.

장점은 핵심 규칙의 독립성이 높고 큰 시스템에서도 변경 범위를 통제하기 좋다는 점이다.
단점은 계층 경계를 유지하기 위한 DTO와 변환 코드가 늘고, 팀에서 의존성 규칙을 꾸준히
지키지 않으면 구조가 빠르게 무너진다는 점이다.

복잡한 업무 규칙이 있고 여러 전달 방식이나 저장 기술을 지원해야 하는 서비스에 맞는다.

## 무엇을 선택할까

세 구조는 서로 완전히 다른 해법이라기보다 강조점이 다르다.

| 기준 | 레이어드 | 헥사고널 | 클린 |
| --- | --- | --- | --- |
| 중심 | 기술 계층 | 포트와 어댑터 | 의존성 방향과 정책 계층 |
| 적합한 경우 | 단순 CRUD, 작은 서비스 | 외부 연동이 많은 서비스 | 규칙이 복잡하고 오래 유지되는 시스템 |
| 초기 비용 | 낮음 | 중간 | 높음 |
| 기술 교체 대응 | 보통 | 좋음 | 좋음 |

현재 프로젝트의 `auth`, `board`, `chat`은 클린 아키텍처 패키지를 사용한다.
이 `hexagonal` 도메인은 같은 CRUD를 포트와 어댑터 방식으로 구성한 비교 예제다.
웹 입력 어댑터는 `EnterBoot`, 도메인·포트·서비스·영속성 출력 어댑터는
`EnterData`에 위치한다. 따라서 모듈 의존성은 `EnterBoot -> EnterData` 한 방향이다.
