package com.android.project.welsenandroidproject_kotlin.ui.rocket_history.rocket_detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.android.project.welsenandroidproject_kotlin.R
import com.android.project.welsenandroidproject_kotlin.databinding.FragmentRocketDetailBinding
import com.android.project.welsenandroidproject_kotlin.ui.base.BaseFragment
import com.android.project.welsenandroidproject_kotlin.ui.base.BaseViewModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RocketDetailFragment : BaseFragment<FragmentRocketDetailBinding>() {

    private val viewModel: RocketDetailViewModel by viewModels()
    private val activityViewModel: RocketDetailActivityViewModel by activityViewModels()
    private val pagerAdapter = RocketDetailPagerAdapter()

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

        setActionBar(titleId = R.string.ship_spec)

        activityViewModel.rocketDetailData.observe(this) {
            pagerAdapter.submitList(it.flickr_images)
            binding?.run {
                with(tvRocketDetailShipName) {
                    text = it.name
                }
                with(tvRocketDetailDescription){
                    text = it.description
                }
                with(vpRocketDetailImage) {
                    adapter = pagerAdapter
                }
                TabLayoutMediator(tbRocketDetail, vpRocketDetailImage) { tab, position ->

                }.attach()
            }
        }
    }
}