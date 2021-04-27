package com.android.project.welsenandroidproject_kotlin.ui.event_history

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.android.project.welsenandroidproject_kotlin.R
import com.android.project.welsenandroidproject_kotlin.databinding.EventHistoryFragmentBinding
import com.android.project.welsenandroidproject_kotlin.ui.base.BaseFragment
import com.android.project.welsenandroidproject_kotlin.ui.base.BaseViewModel

class EventHistoryFragment : BaseFragment<EventHistoryFragmentBinding>() {


    private val viewModel: EventHistoryViewModel by viewModels()

    override fun initParam(data: Bundle) {

    }

    override fun getViewModel(): BaseViewModel? = viewModel

    override fun bindFragmentListener(context: Context) {

    }

    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): EventHistoryFragmentBinding {
        return EventHistoryFragmentBinding.inflate(
            inflater, container, false
        )
    }

    override fun initView(savedInstanceState: Bundle?) {

    }

}