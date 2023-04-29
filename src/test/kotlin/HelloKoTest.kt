import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith

class HelloKoTest : StringSpec({
    "String 길이 테스트" {
        "Hello".length shouldBe 5
        println("Hello World!")
    }
    "Spring startWith 함수 테스트" {
        "World" should startWith("W")
        println("Hello World!")
    }
})