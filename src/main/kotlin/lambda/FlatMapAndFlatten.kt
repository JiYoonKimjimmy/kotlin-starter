package lambda

class Book(
    val title: String,
    val authors: List<String>
)

fun main() {
    val books = listOf(
        Book("Hello", listOf("KIM")),
        Book("Hello Java", listOf("KIM", "JIM")),
        Book("Hello Kotlin", listOf("SOO"))
    )

    println(books.flatMap { it.authors })
    println(books.flatMap { it.authors }.toSet())
    println(books.map { it.authors }.flatten())
    println(books.map { it.authors }.flatten().toSet())

    val deepList = listOf(listOf(1), listOf(2, 3), listOf(4, 5, 6))
    println(deepList.flatten())
}