package com.android.project.welsenandroidproject_kotlin.ui.rocket_history.rocket_detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.android.project.welsenandroidproject_kotlin.databinding.FragmentRocketDetailBinding
import com.android.project.welsenandroidproject_kotlin.ui.base.BaseFragment
import com.android.project.welsenandroidproject_kotlin.ui.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RocketDetailFragment: BaseFragment<FragmentRocketDetailBinding>() {

    private val viewModel: RocketDetailFragmentViewModel by viewModels()

    override fun initParam(data: Bundle) {

    }

    override fun getViewModel(): BaseViewModel? = viewModel

    override fun bindFragmentListener(context: Context) {

    }

    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentRocketDetailBinding {
        return FragmentRocketDetailBinding.inflate(
            inflater,
            container,
            false
        )
    }

    override fun initView(savedInstanceState: Bundle?) {

    }
}