package com.android.project.welsenandroidproject_kotlin.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding>: AppCompatActivity() {

    protected var binding: VB? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = initViewBinding().apply {
            setContentView(root)
        }
        initView(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    protected abstract fun initParam(data: Bundle)

    protected abstract fun getViewModel(): BaseViewModel

    protected abstract fun initViewBinding(): VB

    protected abstract fun initView(savedInstanceState: Bundle?)

    protected fun addFragment(
        containerId: Int,
        fragment: Fragment,
        tag: String? = fragment::class.java.name
    ): FragmentTransaction {
        return supportFragmentManager.beginTransaction()
            .addFragment(containerId, fragment, tag)
    }

    protected fun FragmentTransaction.addFragment(
        containerId: Int,
        fragment: Fragment,
        tag: String? = fragment::class.java.name
    ): FragmentTransaction {
        return this.apply {
            this.add(containerId, fragment, tag)
        }
    }
}