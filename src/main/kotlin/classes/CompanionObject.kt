package classes

class User3 private constructor(val nickName: String) {
    companion object {
        fun newNickName(email: String) = User3(email.substringBefore('@'))
    }
}

fun main() {
    val user = User3.newNickName("jimmyberg.kim@gmail.com")
    println(user.nickName)
}