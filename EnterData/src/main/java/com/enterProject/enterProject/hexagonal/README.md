# 헥사고널 아키텍처

업무 규칙을 중심에 두고 외부 기술을 포트와 어댑터로 연결한다.

```text
EnterBoot: Controller
  -> In Port -> Service -> Out Port
  <- Persistence Adapter -> JPA
```

- 웹과 DB를 교체해도 중심 로직의 영향이 작다.
- 포트를 기준으로 의존 관계가 명확하다.
- 단순 CRUD에서는 인터페이스와 변환 코드가 많아질 수 있다.

이 예제는 `/api/hexagonal/tests` CRUD와 `hexagonal_tests` 테이블을 사용한다.
