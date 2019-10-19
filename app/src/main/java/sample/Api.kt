package sample

import kotlin.concurrent.thread

actual class Api {
    actual fun apiWithFreeze(callback: (Response) -> Unit) {
        thread {
            callback(Response("from jvm"))
        }
    }
//    actual fun apiWithWorker(callback: (Response) -> Unit) {
//        apiWithFreeze(callback)
//    }
}