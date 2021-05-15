package com.android.project.welsenandroidproject_kotlin.ui.base

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.android.project.domain.repository.DataResult
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.processors.BehaviorProcessor
import io.reactivex.rxjava3.subscribers.DisposableSubscriber
import timber.log.Timber

open class BaseViewModel(
    private val state: SavedStateHandle
) : ViewModel() {

    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()
    protected val viewEventPublisher = BehaviorProcessor.create<ViewEvent>().toSerialized()

    fun subscribeViewEvent(eventHandler: (event: ViewEvent) -> Unit): Disposable {
        return viewEventPublisher
            .onBackpressureBuffer(128, true, true)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : BaseViewEventSubscriber() {
                override fun onEvent(event: ViewEvent) {
                    eventHandler(event)
                }
            }).addTo(compositeDisposable)
    }

    fun resetViewEventPublisher() {
        viewEventPublisher.onNext(ViewEvent.None)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun <T> Single<DataResult<T>>.sub(
        onSuccess: (T?) -> Unit = {}
    ): Disposable {
        return subscribe { result, throwable ->
            //val error = throwable ?: (result as? DataResult.Failure<T>)?.errorMessage
            viewEventPublisher.onNext(ViewEvent.Loading)
            if (result is DataResult.Success<T>) {
                onSuccess(result.data)
                viewEventPublisher.onNext(ViewEvent.Done)
            } else if (result is DataResult.Failure<T>) {
                viewEventPublisher.onNext(ViewEvent.Error(result.errorMessage))
            }
        }
    }

    abstract class BaseSubscriber<T> : DisposableSubscriber<T>() {
        override fun onComplete() {

        }

        override fun onNext(t: T) {
            onData(t)
        }

        abstract fun onData(data: T)
    }


    abstract class BaseViewEventSubscriber : BaseSubscriber<ViewEvent>() {

        override fun onData(data: ViewEvent) {
            onEvent(data)
        }

        override fun onError(t: Throwable?) {
            Timber.e(t)
            onEvent(ViewEvent.UnknownError(t))
        }

        abstract fun onEvent(event: ViewEvent)
    }
}