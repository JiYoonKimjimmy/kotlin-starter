package classes

data class DataClassUser(
    val name : String,
    val age: Int
)

fun main() {
    val user1 = DataClassUser(name = "JIM", age = 32)
    val user2 = user1.copy(age = 33)
    println(user1)
    println(user2)
}