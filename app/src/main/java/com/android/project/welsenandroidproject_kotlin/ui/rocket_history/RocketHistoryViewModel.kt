package com.android.project.welsenandroidproject_kotlin.ui.rocket_history

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.android.project.domain.entity.history.RocketHistoryEntity
import com.android.project.domain.use_case.history.GetRocketHistoryUseCase
import com.android.project.welsenandroidproject_kotlin.ui.base.BaseViewModel
import io.reactivex.rxjava3.kotlin.subscribeBy

class RocketHistoryViewModel @ViewModelInject constructor(
    @Assisted state: SavedStateHandle,
    private val rocketHistoryUseCase: GetRocketHistoryUseCase
) : BaseViewModel(state) {

    val rocketHistory = MutableLiveData<List<RocketHistoryEntity>>()


    fun  getRocketHistory(){
        /*rocketHistoryUseCase().subscribeBy {
            rocketHistory.postValue(it)
        }*/
        rocketHistoryUseCase().sub {
            rocketHistory.postValue(it)
        }
    }
}