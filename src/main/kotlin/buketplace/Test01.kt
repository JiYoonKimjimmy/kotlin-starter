package buketplace

class Test01 {
    fun solution(path: String): Array<String> {
        var answer: Array<String> = arrayOf()
        val list = path.toList()
        var skip = 0

        for (i in list.indices) {
            var x = i
            var y = 0

            if (i >= skip) {
                loop@ for (j in (i + 1) until list.size) {
                    val s = Direction.valueOf(list[i].toString())
                    val t = Direction.valueOf(list[j].toString())
                    y += 100
                    if (s != t) {
                        if (y >= 500) {
                            x += ((y - 500) / 100)
                            y = 500
                        }
                        answer += sendMsg(x, y, turn(s, t))
                        skip = j
                        break@loop
                    }
                }
            }
        }
        return answer
    }

    private fun sendMsg(x: Int, y: Int, direction: String) = "Time $x: Go straight $`y`m and turn $direction"

    private fun turn(s: Direction, t: Direction): String {
        return when (s) {
            Direction.E -> if (t == Direction.S) "right" else "left"
            Direction.W -> if (t == Direction.S) "left" else "right"
            Direction.S -> if (t == Direction.E) "left" else "right"
            Direction.N -> if (t == Direction.E) "right" else "left"
        }
    }
}

enum class Direction {
    E, W, S, N
}


fun main() {
    println(Test01().solution("EEESEEEEEENNNN").forEach(::println))
    println(Test01().solution("SSSSSSWWWNNNNNN").forEach(::println))
}
