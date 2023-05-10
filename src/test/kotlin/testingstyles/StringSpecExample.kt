package testingstyles

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringSpecExample : StringSpec({

    "strings.length should return size of string" {
        "hello".length shouldBe 5
    }

    "strings.length should return size of string with config()".config(enabled = false, invocations = 3) {
        "hello world".length shouldBe 11
    }

})