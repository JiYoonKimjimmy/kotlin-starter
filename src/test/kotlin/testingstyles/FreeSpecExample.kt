package testingstyles

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

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