package com.android.project.welsenandroidproject_kotlin.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BaseFragment<VB: ViewBinding>: Fragment(){

    var binding: VB? = null

    //This is for Fragment, should be disposed when onDestroy()
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()

    //This is for Fragment's view, should be disposed when onDestroyView()
    protected val viewCompositeDisposable: CompositeDisposable = CompositeDisposable()

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