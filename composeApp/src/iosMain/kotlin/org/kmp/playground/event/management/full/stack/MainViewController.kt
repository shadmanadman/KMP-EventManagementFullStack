package org.kmp.playground.event.management.full.stack

import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import org.kmp.playground.event.management.full.stack.App.features.core.Core
import org.kmp.playground.event.management.full.stack.App.features.root.AppRootImpl

fun MainViewController() = ComposeUIViewController {
    val lifecycle = LifecycleRegistry()

    val root = AppRootImpl(componentContext = DefaultComponentContext(lifecycle))

    Core(root = root)
}