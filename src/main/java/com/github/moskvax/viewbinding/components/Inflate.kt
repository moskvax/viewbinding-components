package com.github.moskvax.viewbinding.components

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
fun <T : ViewBinding> KClass<T>.inflate(
    inflater: LayoutInflater,
    container: ViewGroup? = null,
    attachToRoot: Boolean = false
): T = java.getDeclaredMethod(
    "inflate",
    LayoutInflater::class.java,
    ViewGroup::class.java,
    Boolean::class.java
).invoke(null, inflater, container, attachToRoot) as T
