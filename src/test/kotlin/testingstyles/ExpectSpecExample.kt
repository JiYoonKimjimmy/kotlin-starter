package testingstyles

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

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