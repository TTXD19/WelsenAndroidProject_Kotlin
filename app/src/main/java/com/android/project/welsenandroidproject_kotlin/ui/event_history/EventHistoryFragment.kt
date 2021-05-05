package com.android.project.welsenandroidproject_kotlin.ui.event_history

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.project.welsenandroidproject_kotlin.R
import com.android.project.welsenandroidproject_kotlin.databinding.EventHistoryFragmentBinding
import com.android.project.welsenandroidproject_kotlin.ui.base.BaseFragment
import com.android.project.welsenandroidproject_kotlin.ui.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class EventHistoryFragment : BaseFragment<EventHistoryFragmentBinding>() {


    private val viewModel: EventHistoryViewModel by viewModels()
    private val adapter = EventHistoryAdapter()

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
        viewModel.getEventHistory()
        viewModel.history.observe(this) {
            binding?.rvEventHistory?.adapter = adapter
            binding?.rvEventHistory?.layoutManager = LinearLayoutManager(this.context)
            adapter.submitList(it)
        }
    }

}