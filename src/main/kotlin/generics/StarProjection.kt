package generics

import kotlin.reflect.KClass

interface FieldValidator<in T> {
    fun validate(input: T): Boolean
}

class StringFieldValidator: FieldValidator<String> {
    override fun validate(input: String) = input.isNotEmpty()
}

class IntFieldValidator: FieldValidator<Int> {
    override fun validate(input: Int) = input >= 0
}

object Validators {
    private val validators = mutableMapOf<KClass<*>, FieldValidator<*>>()

    fun <T: Any> registerValidator(kClass: KClass<T>, validator: FieldValidator<T>) {
        validators[kClass] = validator
    }

    @Suppress("UNCHECKED_CAST")
    operator fun <T: Any> get(kClass: KClass<T>): FieldValidator<T> {
        return validators[kClass] as FieldValidator<T>
    }
}

fun main() {
//    val validators = mutableMapOf<KClass<*>, FieldValidator<*>>()
//    validators[String::class] = StringFieldValidator()
//    validators[Int::class] = IntFieldValidator()
//
//    validators[String::class]!!.validate("")

    Validators.registerValidator(String::class, StringFieldValidator())
    Validators.registerValidator(Int::class, IntFieldValidator())
    println(Validators[String::class].validate("kim"))
    println(Validators[Int::class].validate(123))
}