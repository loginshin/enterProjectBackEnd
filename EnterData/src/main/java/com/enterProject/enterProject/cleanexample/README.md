# 클린 아키텍처

예제 최상위 패키지: `cleanexample`

업무 규칙을 안쪽에 두고 모든 의존성이 안쪽을 향하게 한다.

```text
EnterBoot: Controller
  -> UseCase -> Service -> Gateway
  <- Infrastructure Adapter -> JPA
```

- Domain과 Application이 웹·DB 구현을 직접 알지 않는다.
- 기술 변경의 영향 범위를 줄이기 좋다.
- DTO, Gateway, Mapper가 늘어나 단순 CRUD에는 무거울 수 있다.

이 예제는 `/api/clean/examples` CRUD와 `clean_examples` 테이블을 사용한다.
