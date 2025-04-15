package org.kmp.playground.event.management.full.stack

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMP-EventManagementFullStack",
    ) {
        App()
    }
}