package com.android.project.welsenandroidproject_kotlin.ui.event_history

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import com.android.project.welsenandroidproject_kotlin.ui.base.BaseViewModel

class EventHistoryViewModel @ViewModelInject constructor(
    @Assisted state: SavedStateHandle
) : BaseViewModel(state) {

}