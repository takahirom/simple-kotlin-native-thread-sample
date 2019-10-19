package sample

import platform.darwin.DISPATCH_QUEUE_PRIORITY_DEFAULT
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_global_queue
import kotlin.native.concurrent.freeze

actual class Api {
    actual fun apiWithFreeze(callback: (Response) -> Unit) {
        val block = {
            callback(Response("from ios").freeze())
        }
        block.freeze()
        dispatch_async(
            queue = dispatch_get_global_queue(
                DISPATCH_QUEUE_PRIORITY_DEFAULT.toLong(),
                0.toULong()
            ),
            block = block
        )
    }
}
