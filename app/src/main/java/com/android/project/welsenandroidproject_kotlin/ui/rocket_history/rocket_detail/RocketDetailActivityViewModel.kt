package com.android.project.welsenandroidproject_kotlin.ui.rocket_history.rocket_detail

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import com.android.project.welsenandroidproject_kotlin.ui.base.BaseViewModel
import com.android.project.welsenandroidproject_kotlin.ui.rocket_history.RocketHistoryFragment
import com.android.project.welsenandroidproject_kotlin.ui.rocket_history.RocketHistoryVo

class RocketDetailActivityViewModel @ViewModelInject constructor(
    @Assisted state: SavedStateHandle
) : BaseViewModel(state) {
    val rocketDetailData =
        state.getLiveData<RocketHistoryVo>(RocketHistoryFragment.ROCKET_DETAIL_DATA)
}