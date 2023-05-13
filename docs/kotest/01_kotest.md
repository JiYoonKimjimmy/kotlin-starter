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

- `DescribeSpec` 스타일은 `describe` or `it` 와 같은 키워드를 사용하여 `Ruby` 나 `JavaScript` 스타일과 유사
- 테스트 코드는 하나 이상의 `describe` 블록을 중첩하여 작성
- `xdescribe` or `xit` 를 사용하여 테스트 실행 여부 분리

```kotlin
class DescribeSpecExample: DescribeSpec({
    describe("숫자 비교 테스트") {
        it("0 보다 큰지 비교") {
            1 shouldBeGreaterThan 0
        }
        xdescribe ("0 과 같은지 비교") {
            0 shouldBeEqual 0
        }
        xit ("0 보다 작은지 비교") {
            -1 shouldBeLessThan 0
        }
    }
})
```

---

### `BehaviorSpec`

- `BDD` 스타일로 가장 많이 활용되는 스타일
- `given`, `when`, `then` 키워드를 사용하여 테스트 코드 작성
- `xgiven`, `xwhen`, `xthen` 키워드를 사용하여 테스트 코드 실행 여부 분리

```kotlin
class BehaviorSpecExample: BehaviorSpec({

    given("문자열 길이 비교") {
        val text = "hello"
        val length = 5

        `when`("문자열 길이 같다면") {
            then("성공 처리") {
                text.length shouldBe length
            }
        }
    }
    
})
```

#### `BDD` <small>Behavior Driven Development</small>

`BDD` 는 **행위 주도 개발** 방식으로, `TDD (Test Driven Development)` 에서 파생된 개념이지만,
`TDD` 에서 더 나아가 테스트 케이스 자체를 요구 사항이 되도록 개발 설계하는 방식이다.

##### `BDD` 의 기본 패턴

- `Feature` : 테스트 대상의 기능/책임 명시
- `Scenario` : 테스트 목적에 대한 상황 설명
- `Given` : 시나리오 진행에 필요한 값 설정
- `When` : 시나리오 진행에 필요한 조건 명시
- `Then` : 시나리오 완료한 경우 보장해야 하는 값 명시

> 참고 : [devkuma님 블로그 - BDD(Behavior Driven Development, 행위 주도 개발)](https://www.devkuma.com/docs/testing/bdd/)

---

### `WordSpec`

- `WordSpec` 스타일은 `should` 를 사용하고 `context` 문자열 뒤에 테스트 코드를 중첩
- `When` 을 사용하여 테스트 조건을 명시 가능

```kotlin
class WordSpecExample : WordSpec({
    "String.length" should {
        "return the length of the String" {
            "hello".length shouldBe 5
        }
    }

    "Hello" When {
        "asked for length" should {
            "return 5" {
                "Hello".length shouldBe 5
            }
        }
        "appended to Bob" should {
            "return Hello Bob" {
                "Hello " + "Bob" shouldBe "Hello Bob"
            }
        }
    }
})
```

---

### `FreeSpec`

- `FreeSpec` 스타일은 `-` 키워드를 사용하여 `Outer` 외부 테스트를 정의하고 중첩
- `-` 키워드가 없는 테스트 코드가 최종 테스트

```kotlin
class FreeSpecExample : FreeSpec({
    "String.length" - {
        "should return the length of String" {
            "Hello".length shouldBe 5
        }
    }

    "containers can be nested as deep as you want" - {
        "and so we nest another container" - {
            "yet another container" - {
                "finally a real test" {
                    1 + 1 shouldBe 2
                }
            }
        }
    }
})
```

---

### `FeatureSpec`

- `FeatureSpec` 은 [`Cucumber`](https://cucumber.io/) 와 같은 `feature` 와 `scenario` 키워드 사용 가능
- `xfeature`, `xscenario` 키워드를 사용하여 테스트 코드 실행 여부 분리

```kotlin
class FeatureSpecExample : FeatureSpec({
    feature("문자열 비교") {
        val check = 5
        scenario("문자열 길이가 주어진 숫자와 같다.") {
            "hello".length shouldBe check
        }
        scenario("문자열 길이가 주어진 숫자와 다르다.") {
            "hello world".length shouldNotBe check
        }
    }
})
```

---

### `ExpectSpec`

- `ExpectSpec` 은 `FunSpec`, `ShouldSpec` 과 비슷하지만, `expect` 키워드를 대신 사용
- - `xcontext`, `xexpect` 키워드를 사용하여 테스트 코드 실행 여부 분리

```kotlin
class ExpectSpecExample : ExpectSpec({
    context("문자열 길이 비교") {
        val check = 5
        expect("주어진 숫자와 문자열 길이가 같다.") {
            "hello".length shouldBe check
        }
        xexpect("주어진 숫자와 문자열 길이가 다르다.") {
            "hello world".length shouldNotBe check
        }
    }
})
```

---

### `AnnotationSpec`

- `AnnotationSpec` 을 사용하면 `JUnit` 테스트 코드를 마이그레이션할 때 용이
- `JUnit 4/5` 와 같은 사양을 지원하고, 정의된 테스트 코드 함수에 `@Test` 과 같은 Annotation 추가하면 완료

> `JUnit` 의 다른 Annotation 과도 유사한 Annotation 를 지원
> - `@BeforeAll > @BeforeClass`
> - `@BeforeEach > @Before`
> - `@AfterAll > @AfterClass`
> - `@AfterEach > @After`

```kotlin
class AnnotationSpecExample : AnnotationSpec() {
    @BeforeEach
    fun beforeTest() {
        println("Before each test")
    }

    @Test
    fun test1() {
        1 shouldBe 1
    }

    @Test
    fun test2() {
        3 shouldBe 3
    }
}
```

---

#### 출처 
- [`Kotest` 공식 홈페이지](https://kotest.io/)