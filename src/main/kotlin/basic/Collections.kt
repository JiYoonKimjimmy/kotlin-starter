package basic

fun main() {
    val readOnlyList = listOf(1, 2, 3)              // 읽기 전용 List
    val mutableList = mutableListOf<Int>(1, 2, 3)   // 변경 가능 List

    // readOnlyList.add(4) // 불가
    mutableList.add(4)
}