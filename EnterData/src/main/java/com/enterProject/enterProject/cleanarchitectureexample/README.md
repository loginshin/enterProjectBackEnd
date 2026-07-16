# 클린 아키텍처 상세 예제

예제 최상위 패키지: `cleanarchitectureexample`

```text
domain/model, exception
application/command, result, usecase, gateway, service
infrastructure/persistence/entity, mapper, repository, adapter
EnterBoot/presentation/controller, request, response
```

업무 모델은 JPA와 Spring을 모르고, Application은 Gateway만 사용한다. DB 구현은
Infrastructure가 담당하며 의존성은 Domain 방향으로 향한다. 파일 수는 늘지만 기능별
입출력과 변경 경계가 분명해 복잡한 업무 규칙을 다루기 좋다.

API는 `/api/clean-architecture/articles`, 테이블은 `clean_architecture_articles`를 사용한다.
