package com.android.project.welsenandroidproject_kotlin

import android.os.Bundle
import androidx.activity.viewModels
import com.android.project.welsenandroidproject_kotlin.databinding.ActivityMainBinding
import com.android.project.welsenandroidproject_kotlin.ui.base.BaseActivity
import com.android.project.welsenandroidproject_kotlin.ui.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun initViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getViewModel(): BaseViewModel? = viewModel

    override fun initParam(data: Bundle) {

    }

    override fun initView(savedInstanceState: Bundle?) {
        viewModel.getData()
    }
}