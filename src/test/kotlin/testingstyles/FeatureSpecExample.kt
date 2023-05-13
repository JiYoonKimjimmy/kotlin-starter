package testingstyles

import io.kotest.core.spec.style.FeatureSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

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