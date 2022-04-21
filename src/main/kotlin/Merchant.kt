/**
 * 공통 interface
 * 공통 model
 */

interface MerchantModel<out T> {
    val id: Int

    fun toEntity(): T
}

data class KBMerchantModel(
    override val id: Int,
    val name: String
): MerchantModel<KBMerchantEntity> {
    override fun toEntity() = KBMerchantEntity(
        name = name
    )
}

data class KBMerchantEntity(
    val name: String
)

interface MerchantProcessor<in T, out R> {
    fun process(model: T): R
}

class KBMerchantProcessor<in T, out R> : MerchantProcessor<MerchantModel<T>, R> {

    override fun process(model: MerchantModel<T>): KBMerchantEntity {
        return KBMerchantEntity(
            name = model.id.toString()
        )
    }

}

fun main() {
    val model = KBMerchantModel(
        id = 1,
        name = "KB"
    )

    val processor = KBMerchantProcessor<KBMerchantModel, KBMerchantEntity>()

}