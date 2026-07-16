# 심플 클린 아키텍처

예제 최상위 패키지: `simplecleanarchitectureexample`

```text
EnterBoot: Controller
  -> UseCase -> Service -> Gateway
  <- Persistence Adapter -> JPA
```

하나의 UseCase와 Gateway로 CRUD를 묶은 최소 구성이다. 구조를 빠르게 파악하기 좋지만,
기능이 커지면 인터페이스의 책임이 넓어진다.

API는 `/api/simple-clean-architecture/examples`, 테이블은 `clean_examples`를 사용한다.
