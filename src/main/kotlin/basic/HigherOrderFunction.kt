package basic

fun simpleHOF(sum: (Int, Int) -> Int, a: Int, b: Int): Int = sum(a, b)

fun main() {
    val result = simpleHOF({ x, y -> x + y }, 10, 20)
    println(result)
}