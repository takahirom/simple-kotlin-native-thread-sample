package sample

data class Response(
    var text: String
)

expect class Api {
    fun apiWithFreeze(callback: (Response) -> Unit)
}
