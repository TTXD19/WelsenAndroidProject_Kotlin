package com.android.project.welsenandroidproject_kotlin.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewbinding.ViewBinding
import com.android.project.welsenandroidproject_kotlin.R
import com.google.android.material.appbar.MaterialToolbar
import io.reactivex.rxjava3.disposables.CompositeDisposable
import timber.log.Timber

abstract class BaseFragment<VB: ViewBinding>: Fragment(){

    var binding: VB? = null

    //This is for Fragment, should be disposed when onDestroy()
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()

    //This is for Fragment's view, should be disposed when onDestroyView()
    protected val viewCompositeDisposable: CompositeDisposable = CompositeDisposable()

    protected var toolbar: MaterialToolbar? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = initViewBinding(inflater, container, savedInstanceState)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        toolbar = view.findViewById<MaterialToolbar>(R.id.tb_default)
        initView(savedInstanceState)
    }

    override fun onDestroyView() {
        viewCompositeDisposable.clear()
        binding = null
        super.onDestroyView()
    }

    override fun onDestroy() {
        viewCompositeDisposable.dispose()
        compositeDisposable.dispose()
        super.onDestroy()
    }

    protected fun popFragment(name: String? = null, include: Boolean = false): Boolean {
        childFragmentManager.run {
            if (backStackEntryCount == 0) {
                return false
            }
            if (name != null) {
                popBackStack(name, if (include) FragmentManager.POP_BACK_STACK_INCLUSIVE else 0)
            } else {
                popBackStack()
            }
            return true
        }
    }

    protected fun setActionBar(
        @StringRes titleId: Int? = null,
        title: String? = "default"
    ) {
        (activity as AppCompatActivity).run {
            if (toolbar != null){
                setSupportActionBar(toolbar)
            }
            val actionBarTitle = when {
                titleId != null -> getString(titleId)
                title != null -> title
                else -> null
            }
            supportActionBar?.run {
                this.title = actionBarTitle
            }
        }
    }

    protected fun setActionBarTitle(
        @StringRes titleId: Int? = null,
        title: String? = "default"
    ) {
        val actionBarTitle = when {
            titleId != null -> getString(titleId)
            title != null -> title
            else -> null
        }
        (activity as AppCompatActivity).run {
            supportActionBar?.run {
                toolbar?.title = actionBarTitle
                setTitle(actionBarTitle)
                Timber.tag("barTitle").d(getTitle().toString())
            }
        }
    }

    protected abstract fun initParam(data: Bundle)

    protected abstract fun getViewModel(): BaseViewModel?

    protected abstract fun bindFragmentListener(context: Context)

    protected abstract fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): VB

    protected abstract fun initView(savedInstanceState: Bundle?)


}