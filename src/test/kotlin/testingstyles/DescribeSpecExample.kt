package testingstyles

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.comparables.shouldBeGreaterThan
import io.kotest.matchers.comparables.shouldBeLessThan
import io.kotest.matchers.equals.shouldBeEqual

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