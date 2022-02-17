package classes

interface User {
    val nickName: String
}

class PrivateUser(
    override val nickName: String
) : User

class SubscribingUser(
    private val email: String
) : User {
    override val nickName: String
        get() = email.substringBefore("@")
}

class User2(
    private val name: String
) {
    var address: String = "unknown"
        set(value: String) {
            println("""
                Address was changed for $name: "$field" -> "$value"
            """.trimIndent())
            field = value
        }
}

fun main() {
    println(PrivateUser("test@email.com").nickName)
    println(SubscribingUser("test@email.com").nickName)

    val user = User2("JIM")
    user.address = "Seoul"
    println(user.address)
}