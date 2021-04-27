package com.android.project.welsenandroidproject_kotlin

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import com.android.project.domain.use_case.history.GetRocketHistoryUseCase
import com.android.project.welsenandroidproject_kotlin.ui.base.BaseViewModel
import io.reactivex.rxjava3.kotlin.subscribeBy
import timber.log.Timber

class MainActivityViewModel @ViewModelInject constructor(
    @Assisted savedStateHandle: SavedStateHandle,
    private val getRocketHistoryUseCase: GetRocketHistoryUseCase
) : BaseViewModel(
    savedStateHandle
) {
    fun getData(){
        getRocketHistoryUseCase().subscribeBy {
            Timber.tag("DataResult").d(it[0].company)
        }
    }
}