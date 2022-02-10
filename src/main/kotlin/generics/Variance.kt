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