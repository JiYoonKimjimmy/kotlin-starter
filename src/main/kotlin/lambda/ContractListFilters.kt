package lambda

data class Person(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String?
)

class ContractListFilters {
    var prefix: String = ""
    var onlyWithPhoneNumber: Boolean = false

    fun getPredicate(): (Person) -> Boolean {
        val startsWithPrefix = { p: Person -> p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix)}

        if (!onlyWithPhoneNumber) {
            return startsWithPrefix
        }

        return { startsWithPrefix(it) && it.phoneNumber != null }
    }
}

fun main() {
    val contracts = listOf(
        Person("지윤", "김", "01012341234"),
        Person("수지", "김", null)
    )

    val contractListFilters = ContractListFilters()

    with(contractListFilters) {
        prefix = "지"
        onlyWithPhoneNumber = true
    }

    println(contracts.filter(contractListFilters.getPredicate()))

    var text = "default"
    contracts.forEach {
        if (it.firstName.startsWith("지")) {
            text = it.firstName
            return@forEach
        }
        println("Hello $text")
    }
}