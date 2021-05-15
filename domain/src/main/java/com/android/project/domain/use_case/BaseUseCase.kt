package com.android.project.domain.use_case

import com.android.project.domain.repository.DataResult
import io.reactivex.rxjava3.core.Single

abstract class BaseUseCase<R> {
    abstract fun buildUseCase(): Single<R>

    operator fun invoke(): Single<DataResult<R>> {
        return buildUseCase().map<DataResult<R>> {
            DataResult.Success(it)
        }.onErrorReturn {
            DataResult.Failure()
        }
    }
}