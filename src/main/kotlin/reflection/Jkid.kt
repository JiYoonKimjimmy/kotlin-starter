package reflection

import kotlin.reflect.full.memberProperties

class User(
    val name: String
)

fun serialize(obj: Any): String = buildString { serializeObject(obj) }

private fun StringBuilder.serializeObject(obj: Any) {
    val kClass = obj.javaClass.kotlin
    val properties = kClass.memberProperties

    properties.joinToString(this, prefix = "{", postfix = "}") { prop ->
        println(prop.name)
        println(prop.get(obj))
        append("${prop.name}: ${prop.get(obj)}")
    }
}

fun main() {
    val user = User("KIM")

    serialize(user)
}