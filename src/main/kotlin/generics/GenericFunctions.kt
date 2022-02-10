package generics

import java.lang.IllegalArgumentException
import java.lang.StringBuilder

fun main() {
    val authors = listOf("KIM")
    val readers = mutableListOf<String>("KIM", "JI", "YOON")
    println(readers[2])
    println(readers.filter { it in authors })   // ["KIM"]

    println(ensureTrailingPeriod(StringBuilder("Hello World")))

}

fun <T> ensureTrailingPeriod(seq: T): T where T : CharSequence, T : Appendable {
    if (!seq.endsWith('.')) {
        seq.append('.')
    }
    return seq
}

fun <T> print(value: T) {
    println(value)
}

fun isCheck(value: Any): Boolean {
    return value is List<*>
}


fun printSum(c: Collection<*>) {
    val intList = c as? List<Int> ?: throw IllegalArgumentException()
}