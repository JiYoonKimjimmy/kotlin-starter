package basic

import java.lang.IllegalArgumentException

class User(
    val id: Long,
    val name: String,
    val address: String
)

fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user $id: Empty $fieldName")
        }
    }

    validate(name, "Name")
    validate(address, "Address")
}

fun saveUser(user: User) {
    user.validateBeforeSave()
    println(user.toString())
}

fun main() {
    println("Validate User Test!!")
    saveUser(User(1, "김지윤", "서울시 우리집 없어!"))
    val list = listOf(1, 2, 3)

    println(list.joinToString(", ", "[", "]"))
}