package com.android.project.welsenandroidproject_kotlin.ui.rocket_history.rocket_detail

import android.os.Bundle
import androidx.activity.viewModels
import com.android.project.welsenandroidproject_kotlin.R
import com.android.project.welsenandroidproject_kotlin.databinding.ActivityRocketDetailBinding
import com.android.project.welsenandroidproject_kotlin.ui.base.BaseActivity
import com.android.project.welsenandroidproject_kotlin.ui.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RocketDetailActivity : BaseActivity<ActivityRocketDetailBinding>() {

    private val viewModel: RocketDetailViewModel by viewModels()

    override fun initViewBinding(): ActivityRocketDetailBinding {
        return ActivityRocketDetailBinding.inflate(
            layoutInflater
        )
    }

    override fun getLayoutId(): Int = R.layout.activity_rocket_detail

    override fun getViewModel(): BaseViewModel? = viewModel

    override fun initParam(data: Bundle) {

    }

    override fun initView(savedInstanceState: Bundle?) {
        addFragment(
            R.id.fl_rocket_detail,
            RocketDetailFragment()
        ).safeCommit()
    }
}