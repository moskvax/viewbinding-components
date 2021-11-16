package com.github.moskvax.viewbinding.components

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import kotlin.reflect.KClass

abstract class ViewBindingActivity<T : ViewBinding> : AppCompatActivity() {
    protected abstract val viewBindingClass: KClass<T>
    private lateinit var _binding: T
    protected val binding: T get() = _binding

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBindingClass.inflate(layoutInflater).also {
            _binding = it
            setContentView(it.root)
        }
    }
}
