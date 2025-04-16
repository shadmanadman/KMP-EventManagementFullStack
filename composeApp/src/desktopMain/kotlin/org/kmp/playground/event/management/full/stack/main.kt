package org.kmp.playground.event.management.full.stack

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry

import org.kmp.playground.event.management.full.stack.App.features.core.Core
import org.kmp.playground.event.management.full.stack.App.features.root.AppRootImpl

fun main() {
    val lifecycle = LifecycleRegistry()

    val root = AppRootImpl(componentContext = DefaultComponentContext(lifecycle))

    application {

        Window(
            onCloseRequest = ::exitApplication,
            title = "KMP-EventManagementFullStack",
        ) {

            Core(root = root)
        }
    }
}