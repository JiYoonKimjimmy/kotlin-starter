package testingstyles

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class BehaviorSpecExample : BehaviorSpec({

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