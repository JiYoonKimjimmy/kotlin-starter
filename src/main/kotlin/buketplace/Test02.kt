package buketplace

import java.util.*

class Test02 {
    fun solution(call: String): String {
        var answer: String = call
        val map = mutableMapOf<String, Int>()
        for (i in call.indices) {
            for (j in (i + 1)..call.length) {
                val s = call.substring(i, j)
                map[s] = map[s]?.plus(1) ?: 1
            }
        }
        val max = map.maxOf { it.value }
        map.mapNotNull { (k, v) -> if (v == max) k else null }
            .forEach {
                answer = answer
                    .replace(it.lowercase(Locale.getDefault()), "")
                    .replace(it.uppercase(Locale.getDefault()), "")
            }
        return answer
    }
}

fun main() {
    println(Test02().solution("abcabca"))
    println(Test02().solution("abcabcdefabc"))
    println(Test02().solution("abxdeydeabz"))
    println(Test02().solution("ABCabcA"))
}