package basic

fun main() {
    val arr = arrayOf(1, 2, 3)
    println(arr.joinToString())

    val arrOfyNulls = arrayOfNulls<Int>(5)
    println(arrOfyNulls.joinToString())

    val intArr1 = intArrayOf(1, 2, 3)

    val intArr = IntArray(5) { i -> (i + 1) * (i + 1)}
    println(intArr.joinToString())
}