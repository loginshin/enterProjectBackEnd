# Architecture guide

The production domains (`auth`, `board`, and `chat`) use a package-by-feature
Clean Architecture layout.

```text
<domain>/
├─ domain/                  enterprise rules and domain objects
├─ application/
│  ├─ usecase/              input boundaries called by presentation
│  ├─ gateway/              output boundaries implemented by infrastructure
│  ├─ command/              use-case input models
│  ├─ result/               use-case output models
│  └─ service/              use-case implementations
├─ presentation/web/        controllers and HTTP DTOs
└─ infrastructure/persistence/ JPA entities, repositories, and gateway implementations
```

Dependencies must point inward: presentation and infrastructure may depend on
application/domain, application may depend on domain, and domain must remain
independent of Spring, web, and persistence details.

`hexagonalexample` is a small executable CRUD reference that preserves the
ports-and-adapters layout. It exposes `/api/hexagonal/tests` and uses the
`hexagonal_tests` table so each architectural role can be followed end to end.
