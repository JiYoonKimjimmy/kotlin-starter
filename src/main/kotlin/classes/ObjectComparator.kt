package classes

data class Person2(val name: String) {
    object NameComparator : Comparator<Person2> {
        override fun compare(p1: Person2, p2: Person2): Int = p1.name.compareTo(p2.name)
    }
}

fun main() {
    val people = listOf(Person2("KIM"), Person2("JIM"))
    println(people.sortedWith(Person2.NameComparator))
}