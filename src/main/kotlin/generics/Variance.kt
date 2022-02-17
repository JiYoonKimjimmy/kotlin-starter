package generics

open class Animal {
    fun feed() = println("FEED!!")
}

class Herd<out T: Animal> {
    val size: Int
        get() = TODO()
    operator fun get(i: Int): T {
        TODO()
    }
}

fun feedAll(animals: Herd<Animal>) {
    for (i in 0 until animals.size) {
        animals[i].feed()
    }
}

class Cat: Animal() {
    fun cleanLitter(): Nothing = TODO()
}

fun takeCareOfCats(cats: Herd<Cat>) {
    for (i in 0 until cats.size) {
        cats[i].cleanLitter()
        feedAll(cats)
    }
}

fun printContents(list: List<Any>) {
    println(list.joinToString())
}

fun addAnswer(list: MutableList<Any>) {
    list.add(42)
}

fun subtype(i: Int) {
    val n: Number = i
}

fun main() {
    printContents(listOf("abc", "cba"))

//    val strings = mutableListOf<Any>("abc", "cba")
//    addAnswer(strings)
//    println(strings)
//    println(strings.maxByOrNull { it.length })

    val anyComparator = Comparator<Any> {
        e1, e2 -> e1.hashCode() - e2.hashCode()
    }

    val strings = listOf("abc", "cba")
    println(strings)
    strings.sortedWith(anyComparator)
    println(strings)
}