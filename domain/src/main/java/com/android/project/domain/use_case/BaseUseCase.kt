package com.android.project.domain.use_case

import io.reactivex.rxjava3.core.Single

abstract class BaseUseCase<R> {
    abstract fun buildUseCase(): Single<R>

    operator fun invoke(): Single<R> {
        return buildUseCase()
    }
}