package com.android.project.welsenandroidproject_kotlin.ui.base

import android.database.ContentObserver
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.viewbinding.ViewBinding
import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BaseActivity<VB: ViewBinding>: AppCompatActivity() {
    protected lateinit var params: Bundle
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private var toast: Toast? = null
    private var screenshotObserver: ContentObserver? = null
    protected var binding: VB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        params = intent.extras ?: Bundle.EMPTY
        initParam(params)
        binding = initViewBinding().apply {
            setContentView(root)
        }
        initView(savedInstanceState)

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        if (screenshotObserver != null) {
            contentResolver.unregisterContentObserver(screenshotObserver!!)
        }
        binding = null
        super.onDestroy()
    }

    protected fun addFragment(
        containerId: Int,
        fragment: Fragment,
        tag: String? = fragment::class.java.name,
    ): FragmentTransaction {
        return supportFragmentManager.beginTransaction()
            .addFragment(containerId, fragment, tag)
    }

    protected fun FragmentTransaction.addFragment(
        containerId: Int,
        fragment: Fragment,
        tag: String? = fragment::class.java.name,
    ): FragmentTransaction {
        return this.apply {
            this.add(containerId, fragment, tag)
        }
    }

    protected fun FragmentTransaction.safeCommit() {
        if (supportFragmentManager.isStateSaved) {
            this.commitAllowingStateLoss()
        } else {
            this.commit()
        }
    }

    protected abstract fun initViewBinding(): VB

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected abstract fun getViewModel(): BaseViewModel?

    protected abstract fun initParam(data: Bundle)

    protected abstract fun initView(savedInstanceState: Bundle?)
}