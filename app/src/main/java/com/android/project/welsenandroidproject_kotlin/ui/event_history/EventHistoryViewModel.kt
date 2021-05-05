package com.android.project.welsenandroidproject_kotlin.ui.event_history

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.android.project.domain.entity.history.EventHistoryEntity
import com.android.project.domain.use_case.history.GetEventHistoryUseCase
import com.android.project.welsenandroidproject_kotlin.ui.base.BaseViewModel
import io.reactivex.rxjava3.kotlin.subscribeBy

class EventHistoryViewModel @ViewModelInject constructor(
    @Assisted state: SavedStateHandle,
    private val getEventHistoryUseCase: GetEventHistoryUseCase
) : BaseViewModel(state) {

    val history = MutableLiveData<List<EventHistoryEntity>>()

    fun getEventHistory(){
        getEventHistoryUseCase().subscribeBy {
            history.postValue(it)
        }
    }
}