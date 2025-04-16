package org.kmp.playground.event.management.full.stack.CMS.features.splash

import com.arkivanov.decompose.ComponentContext

class SplashComponentImpl(
    componentContext: ComponentContext,
    val onSplashTimeFinished: () -> Unit
) : SplashComponent, ComponentContext by componentContext {
    override fun onSplashTimeFinish() {
        onSplashTimeFinished()
    }
}