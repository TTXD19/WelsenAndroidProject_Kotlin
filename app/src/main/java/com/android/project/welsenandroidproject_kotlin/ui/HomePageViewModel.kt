package com.android.project.welsenandroidproject_kotlin.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import com.android.project.welsenandroidproject_kotlin.ui.base.BaseViewModel

class HomePageViewModel @ViewModelInject constructor(
    @Assisted savedStateHandle: SavedStateHandle
) : BaseViewModel(savedStateHandle) {

}