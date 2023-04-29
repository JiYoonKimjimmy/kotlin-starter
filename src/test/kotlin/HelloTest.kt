import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class HelloTest {

    private var hello: String = ""

    @BeforeEach
    fun before() {
        hello = "Hello"
    }

    @AfterEach
    fun after() {
        println("$hello World!")
    }

    @Test
    fun `문자열 일치 테스트`() {
        assertEquals(hello, "Hello")
    }

    @Test
    fun `문자열 불일치 테스트`() {
        assertNotEquals(hello, "hello")
    }

}
