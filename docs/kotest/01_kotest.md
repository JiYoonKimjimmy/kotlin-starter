# `Kotest` STARTer

## Kotest Testing Styles

`Kotest` 의 테스트 코드 작성 방법의 다양한 스타일들이 있다.

---

### `FunSpec`

- `test()`, `context()` 함수에 테스트 문자열을 전달하여 테스트 코드를 실행하고, 람다 함수에 테스트 코드를 정의하는 방식
- `x` 문자를 함수 앞에 추가하면 테스트 코드 실행하지 않고 `Skip` 처리

```kotlin
class FunSpecExample : FunSpec({
    test("String length should return the length of the string") {
        "sammy".length shouldBe 5
        "".length shouldBe 0
    }
    // `xtest()` 함수는 테스트 미실행 
    context("this outer block is enabled") {
        xtest("this test is disabled") {
            "hi".length shouldBe 2
        }
    }
})
```

---

### `StringSpec`

- 문자열로 테스트를 구분한 다음에 테스트 코드를 입력하여 코드 작성 최소화
- `.config()` 함수를 사용하여 테스트 코드 실행에 대한 설정 가능

```kotlin
class StringSpecExample : StringSpec({
    "strings.length should return size of string" {
        "hello".length shouldBe 5
    }
    // `enabled = false` 설정으로 테스트 미실
    "strings.length should return size of string with config()".config(enabled = false, invocations = 3) {
        "hello world".length shouldBe 11
    }
})
```

---

### `ShouldSpec`

- `FunSpec` 과 유사한 스타일이지만, `should()` 함수를 사용
- 하나의 테스트 블록 안에서 중첩 테스트 코드 작성 가능

```kotlin
class ShouldSpecExample : ShouldSpec({
    should("return the length of the string") {
        "sammy".length shouldBe 5
        "".length shouldBe 0
    }
    context("String.length") {
        should("return the length of the string") {
            "sammy".length shouldBe 5
            "".length shouldBe 0
        }
        // `xshould()` 함수인 경우, 테스트 미실행 
        xshould("return the length of the string") {
            "hello world".length shouldBe 11
        }
    }
})
```

---

### `DescribeSpec`

---

### `BehaviorSpec`

---

### `WordSpec`

---

### `FreeSpec`

---

### `FeatureSpec`

---

### `ExpectSpec`

---

### `AnnotationSpec`

---

#### 출처 
- [`Kotest` 공식 홈페이지](https://kotest.io/)