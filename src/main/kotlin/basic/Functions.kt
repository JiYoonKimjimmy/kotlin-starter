package basic

fun printMessage(message: String): Unit {
    println(message)
}

fun sumNumber(x: Int, y: Int) = x + y

class MyString {
    var string = ""
    infix fun add(other: String) {
        this.string = this.string + other
    }
}

fun main() {
    println("Function basic.")

    // basic function
    printMessage("Hello, World")
    println(sumNumber(1, 2))

    // infix function
    val myString = MyString()
    myString add "Hello"
    myString add "Kotlin"
    myString add "World"
    println(myString.string)

    // operator function
    operator fun Int.times(str: String) = str.repeat(this)
    operator fun String.get(range: IntRange) = substring(range)

    println(2 * "Hello ")
    println("Hello Kotlin world"[0..12])

    // vararg parameter function
    fun printAll(vararg messages: String) {
        for (m in messages) println(m)
    }

    printAll("vararg", "parameter", "function", "test")
}