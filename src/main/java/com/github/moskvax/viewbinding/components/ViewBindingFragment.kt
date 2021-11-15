package com.github.moskvax.viewbinding.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlin.reflect.KClass

abstract class ViewBindingFragment<T : ViewBinding> : Fragment() {
    protected abstract val viewBindingClass: KClass<T>
    private var _binding: T? = null
    protected val binding: T get() = _binding!!

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = viewBindingClass.inflate(inflater, container)
        .also { _binding = it }
        .root

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
