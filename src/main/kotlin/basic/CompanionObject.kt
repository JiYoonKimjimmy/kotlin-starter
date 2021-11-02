package basic

class CompanionObject {
    companion object {
        private val a: String = "a"
        private val b: String = "b"
        override fun toString(): String = listOf(a, b).joinToString(".")
    }
}

fun main() {
    println(CompanionObject.toString())
}