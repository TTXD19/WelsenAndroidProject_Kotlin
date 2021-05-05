package com.android.project.welsenandroidproject_kotlin.ui.rocket_history

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.project.welsenandroidproject_kotlin.databinding.FragmentRocketHistoryBinding
import com.android.project.welsenandroidproject_kotlin.ui.base.BaseFragment
import com.android.project.welsenandroidproject_kotlin.ui.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RocketHistoryFragment : BaseFragment<FragmentRocketHistoryBinding>(), RocketHistoryAdapter.Listener {

    private val viewModel: RocketHistoryViewModel by viewModels()
    private val adapter = RocketHistoryAdapter(this)

    override fun initParam(data: Bundle) {

    }

    override fun getViewModel(): BaseViewModel? = viewModel

    override fun bindFragmentListener(context: Context) {

    }

    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentRocketHistoryBinding {
        return FragmentRocketHistoryBinding.inflate(
            inflater,
            container,
            false
        )
    }

    override fun initView(savedInstanceState: Bundle?) {

        viewModel.getRocketHistory()
        viewModel.rocketHistory.observe(this){
            binding?.rvRocketHistory?.adapter = adapter
            binding?.rvRocketHistory?.layoutManager = LinearLayoutManager(this@RocketHistoryFragment.context)
            adapter.submitList(it)
        }
    }

    override fun onClick() {

    }

}