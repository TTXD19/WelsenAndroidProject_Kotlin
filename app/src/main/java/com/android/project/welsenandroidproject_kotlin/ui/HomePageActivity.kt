package com.android.project.welsenandroidproject_kotlin.ui

import android.os.Bundle
import androidx.activity.viewModels
import com.android.project.welsenandroidproject_kotlin.R
import com.android.project.welsenandroidproject_kotlin.databinding.ActivityHomePageBinding
import com.android.project.welsenandroidproject_kotlin.ui.base.BaseActivity
import com.android.project.welsenandroidproject_kotlin.ui.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomePageActivity: BaseActivity<ActivityHomePageBinding>(){


    private val viewModel: HomePageViewModel by viewModels()

    override fun initViewBinding(): ActivityHomePageBinding {
        return ActivityHomePageBinding.inflate(
            layoutInflater
        )
    }

    override fun getLayoutId(): Int = R.layout.activity_home_page

    override fun getViewModel(): BaseViewModel? = viewModel

    override fun initParam(data: Bundle) {

    }

    override fun initView(savedInstanceState: Bundle?) {

    }
}