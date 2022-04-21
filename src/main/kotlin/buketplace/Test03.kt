package buketplace

class Test03 {

    private val map = mutableMapOf<String, String>()
    private var count = 0

    fun solution(tstring: String, variables: Array<Array<String>>): String {
        variables.forEach { (k, v) ->
            map["{$k}"] = v
        }
        val list = tstring.split(" ").toMutableList()
        for (i in list.indices) {
            if (map.containsKey(list[i])) {
                val value = map[list[i]].toString()
                list[i] = check(value)
                count = 0
            }
        }
        return list.joinToString(" ")
    }

    private fun check(value: String): String {
        return if (map.containsKey(value) && count < 10) {
            count++
            check(map[value].toString())
        } else {
            value
        }
    }
}

fun main() {
    println(Test03().solution("this is {template} {template} is {state}", arrayOf(arrayOf("template", "string"), arrayOf("state", "changed"))))
    println(Test03().solution("this is {template} {template} is {state}", arrayOf(arrayOf("template", "string"), arrayOf("state", "{template}"))))
    println(Test03().solution("this is {template} {template} is {state}", arrayOf(arrayOf("template", "{state}"), arrayOf("state", "{template}"))))
}