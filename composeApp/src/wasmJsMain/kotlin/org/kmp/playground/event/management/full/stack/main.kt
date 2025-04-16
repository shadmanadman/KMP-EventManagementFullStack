package org.kmp.playground.event.management.full.stack

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import org.kmp.playground.event.management.full.stack.App.features.root.AppRootImpl
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import org.kmp.playground.event.management.full.stack.App.features.core.Core

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    val lifecycle = LifecycleRegistry()

    val root = AppRootImpl(componentContext = DefaultComponentContext(lifecycle))
    ComposeViewport(document.body!!) {
        Core(root = root)
    }
}