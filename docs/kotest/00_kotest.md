# `Kotest` STARTer

## `Kotest` 테스트 코드 학습

- `JUnit5` 기반의 `Kotest` 를 활용한 테스트코드 작성 연습
- `Kotlin` 프로젝트인 경우, 테스트코드를 좀 더 ***코틀린스럽게*** 작성 가능

---

## `Kotest` 환경 구성

### Gradle 설정

- `Kotest` 라이브러리는 `Gradle` 의존성 주입으로 간단하게 설정 가능하다.
- `Kotest` 라이브러리 버전별로 사용하는 `Kotlin` 버전이 다르다.
- 현재 프로젝트의 `Kotlin` 버전과 `Kotest` 의 `Kotlin` 버전이 일치해야 한다.

```groovy
dependencies {
    // `build.gradle.kts` 수정
    testImplementation("io.kotest:kotest-runner-junit5:5.6.1")
    // ...
}
```

### `Kotest` 플러그인 설정

- 실제 `Kotest` 로 작성한 테스트코드를 실행하기 위해서는 `Kotest` 플러그인 설치가 필요하다.
- `IntelliJ IDEA` 플러그인 설치를 하면 손쉽게 해결된다.

---

## `Kotest` 사용 방법

- TODO 계속 작성 예정

---

#### 출처 
- [`Kotest` 공식 홈페이지](https://kotest.io/)