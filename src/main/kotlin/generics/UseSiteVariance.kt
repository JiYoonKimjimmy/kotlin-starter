package generics

class DataUtil {
    fun <T> copyData(source: List<T>, destination: MutableList<T>) {
        for (item in source) {
            destination.add(item)
        }
    }
}

fun main() {
    val source = listOf(1, 2, 3)
    val destination = mutableListOf<Any>()
    println(destination)
    DataUtil().copyData(source, destination)
    println(destination)
}