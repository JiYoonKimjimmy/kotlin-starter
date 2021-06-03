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
    // basic function
    printMessage("Hello, World")
    println(sumNumber(1, 2))

    // infix function
    val myString = MyString()
    myString add "Hello"
    myString add "Kotlin"
    myString add "World"
    println(myString.string)
    
}