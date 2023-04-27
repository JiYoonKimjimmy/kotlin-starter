import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class HelloWorldTest {

    private var hello: String = ""

    @Before
    fun before() {
        hello = "Hello"
    }

    @After
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
