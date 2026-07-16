# 레이어드 아키텍처

기술 역할에 따라 코드를 계층으로 나누고 위에서 아래로 호출한다.

```text
EnterBoot: Controller
  -> EnterData: Service -> Repository -> Entity
```

- 구조가 단순해 CRUD 기능을 빠르게 만들기 좋다.
- 흐름이 익숙해서 코드를 찾기 쉽다.
- Service가 Repository와 Entity에 직접 의존하므로 규모가 커지면 결합도가 높아질 수 있다.

이 예제는 `/api/layered/examples` CRUD와 `layered_examples` 테이블을 사용한다.
