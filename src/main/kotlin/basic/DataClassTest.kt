interface CustomHttpResponse {
    val code: String
    val message: String
    val data: Any
}

data class ApiResponse(
    val resCode: String,
    val resMessage: String,
    val resData: Any
): CustomHttpResponse {
    override val code: String get() = this.resCode
    override val message: String get() = this.resMessage
    override val data: Any get() = if (code == "-1") resData.toString() else resData as List<*>
}

fun main() {
    val data = ApiResponse("1", "", listOf(1, 2, 3))
    println(data.toString())
    println(data.data is String)
}