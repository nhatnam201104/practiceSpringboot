# Backend (Spring Boot)

Base project structure for a Spring Boot 4.x backend using Java 21, Spring Web MVC, Spring Data JPA (Hibernate) + MySQL, Spring Data Redis, Spring Security, Validation, MapStruct, Lombok, springdoc OpenAPI, and Docker Compose.

## Requirements

- Java 21
- Maven 3.9+ (or use the included `mvnw` wrapper)
- Docker & Docker Compose (for local MySQL + Redis)
- Windows / macOS / Linux

## Project Layout

```
src/main/java/com/example/backend
├── BackendApplication.java
├── common
│   ├── config        (OpenApiConfig, RedisConfig, JpaAuditingConfig)
│   ├── exception     (ErrorCode, AppException, GlobalExceptionHandler)
│   ├── response      (ApiResponse)
│   ├── security      (SecurityConfig, CustomAuthenticationEntryPoint, CustomAccessDeniedHandler)
│   ├── constant      (AppConstants)
│   └── util          (DateTimeUtils)
├── domain
│   ├── entity        (BaseEntity)
│   ├── repository    (BaseRepository)
│   ├── dto           (PageRequestDto, PageResponseDto)
│   └── mapper        (BaseMapper)
└── modules
    └── sample        (controller, service, repository, entity, dto, mapper)
```

## Environment Variables

All sensitive values are read from environment variables with sensible local defaults.

| Variable             | Default          | Purpose                      |
|----------------------|------------------|------------------------------|
| `SERVER_PORT`        | `8080`           | HTTP port                    |
| `SPRING_PROFILES_ACTIVE` | `local`       | Active Spring profile        |
| `DB_HOST`            | `localhost`      | MySQL host                   |
| `DB_PORT`            | `3306`           | MySQL port                   |
| `DB_NAME`            | `backend`        | MySQL database name          |
| `DB_USERNAME`        | `root`           | MySQL username               |
| `DB_PASSWORD`        | _(empty)_        | MySQL password               |
| `REDIS_HOST`         | `localhost`      | Redis host                   |
| `REDIS_PORT`         | `6379`           | Redis port                   |
| `REDIS_PASSWORD`     | _(empty)_        | Redis password               |

You can also use a `.env` file at the project root for Docker Compose (see `docker-compose.yml`).

## Run MySQL + Redis

```bash
docker compose up -d
```

Stop and remove containers + network (keeps the `mysql_data` volume):

```bash
docker compose down
```

## Run the App (local)

```bash
./mvnw spring-boot:run
```

Or build a jar:

```bash
./mvnw clean package
java -jar target/backend-0.0.1-SNAPSHOT.jar
```

The app boots on `http://localhost:8080`.

## Verify

### Health

```bash
curl http://localhost:8080/actuator/health
```

Expected: `{"status":"UP"}`.

### Swagger UI

- OpenAPI JSON: <http://localhost:8080/v3/api-docs>
- Swagger UI:   <http://localhost:8080/swagger-ui.html>

### Sample ping endpoint

`GET /api/sample/ping` is currently `authenticated` per the base security policy.
A successful request returns:

```json
{
  "success": true,
  "code": "SUCCESS",
  "message": "Thành công",
  "data": "pong",
  "timestamp": "2026-07-03T10:15:30Z"
}
```

## Tests

Tests use the `test` Spring profile (`src/test/resources/application-test.yml`) which boots an in-memory H2 database (MySQL mode) so the context loads without a running MySQL server.

```bash
./mvnw test
```
