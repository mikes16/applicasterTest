package com.mikelop.applicastertest.common.interactor

import com.mikelop.applicastertest.common.Failure
import com.mikelop.applicastertest.common.functional.Either
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

typealias CompletionBlock<T> = (Either<Failure, T>) -> Unit

abstract class UseCase<out Type, in Params> where Type : Any {

    private var parentJob: Job = Job()
    private var backgroundContext: CoroutineContext = Dispatchers.IO
    private var foregroundContext: CoroutineContext = Dispatchers.Main

    abstract suspend fun run(params: Params): Either<Failure, Type>


    operator fun invoke(params: Params, onResult: CompletionBlock<Type>) {
        unsubscribe()
        parentJob = Job()
        CoroutineScope(foregroundContext + parentJob).launch{
            val result = withContext(backgroundContext) {
                run(params)
            }

            onResult(result)
        }
    }

    fun unsubscribe() {
        parentJob.apply {
            cancelChildren()
            cancel()
        }
    }

    class None
}