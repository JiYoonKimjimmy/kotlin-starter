package testingstyles

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

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
        xshould("return the length of the string") {
            "hello world".length shouldBe 11
        }
    }

})