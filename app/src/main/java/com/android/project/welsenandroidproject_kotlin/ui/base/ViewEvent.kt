package com.android.project.welsenandroidproject_kotlin.ui.base

sealed class ViewEvent {
    object Loading : ViewEvent()
    object FullscreenLoading : ViewEvent()
    object Done : ViewEvent()

    object SignOut : ViewEvent()
    data class Error(val message: String) : ViewEvent()
    data class UnknownError(val error: Throwable?) : ViewEvent()
    object None : ViewEvent()


    abstract class Data : ViewEvent()

    //Data event should inherit this class
    abstract class ViewEventData<T>(val data: T? = null) : ViewEvent.Data()

    abstract class ViewEventError(val error: String? = "network Error") : ViewEvent.Data()
}