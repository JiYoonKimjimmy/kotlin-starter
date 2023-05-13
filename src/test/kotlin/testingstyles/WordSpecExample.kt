package testingstyles

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

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