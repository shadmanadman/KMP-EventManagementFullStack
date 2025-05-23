package org.kmp.playground.event.management.full.stack.CMS.features.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import org.kmp.playground.event.management.full.stack.CMS.features.splash.SplashComponent

interface AppRoot{
    val backstack: Value<ChildStack<*, MainDestinationsChild>>

    sealed class MainDestinationsChild{
        class Splash(
            val component: SplashComponent,
        ) : MainDestinationsChild()
    }
}