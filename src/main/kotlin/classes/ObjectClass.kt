package classes

class Person(val name: String)

object People {
    val people = arrayListOf<Person>()

    fun printName() {
        people.map(Person::name).forEach(::println)
    }
}

fun main() {
    People.people.add(Person("JIM"))
    People.people.add(Person("KIM"))
    People.printName()
}