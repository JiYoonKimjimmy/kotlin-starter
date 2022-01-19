package basic

class Variables {
}

fun main() {
    println(strLen2("null"))
}

fun strLen(s: String?) = s?.length

fun strLen2(s: String?) = (s ?: "").length