package com.android.project.welsenandroidproject_kotlin.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.android.project.welsenandroidproject_kotlin.R
import com.android.project.welsenandroidproject_kotlin.databinding.FragmentHomePageBinding
import com.android.project.welsenandroidproject_kotlin.ui.base.BaseFragment
import com.android.project.welsenandroidproject_kotlin.ui.base.BaseViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomePageFragment : BaseFragment<FragmentHomePageBinding>() {

    private val viewModel: HomePageFragmentViewModel by viewModels()


    override fun initParam(data: Bundle) {}

    override fun getViewModel(): BaseViewModel? = viewModel

    override fun bindFragmentListener(context: Context) {

    }

    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentHomePageBinding {
        return FragmentHomePageBinding.inflate(
            inflater,
            container,
            false
        )
    }

    override fun initView(savedInstanceState: Bundle?) {
        setActionBar(titleId = R.string.history)
        binding?.run {
            val tabLayout = root.findViewById<TabLayout>(R.id.tl_tab)
            val rocketEventViewPagerAdapter = HomePagePagerAdapter(this@HomePageFragment)
            vpHomePage.apply {
                adapter = rocketEventViewPagerAdapter
                TabLayoutMediator(tabLayout, this) { tab, position ->
                    when (position) {
                        0 -> tab.text = getString(R.string.rocket)
                        1 -> tab.text = getString(R.string.event)
                    }
                }.attach()
            }
        }
    }
}