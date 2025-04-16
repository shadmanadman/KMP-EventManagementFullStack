package org.kmp.playground.event.management.full.stack.CMS.features.root

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.replaceCurrent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import org.kmp.playground.event.management.full.stack.CMS.features.splash.SplashComponentImpl

class AppRootImpl(
    private val componentContext: ComponentContext
) : AppRoot, ComponentContext by componentContext {
    private val mainDispatcher = CoroutineScope(Dispatchers.Main)

    private val navigation = StackNavigation<MainNavigationConfig>()

    private val _backstack = this.childStack(
        source = navigation,
        serializer = MainNavigationConfig.serializer(),
        initialConfiguration = MainNavigationConfig.Splash,
        handleBackButton = true,
    ) { config, context ->
        createChildFactory(
            config = config, componentContext = context
        )
    }

    override val backstack = _backstack

    private fun createChildFactory(
        config: MainNavigationConfig,
        componentContext: ComponentContext
    ): AppRoot.MainDestinationsChild {
        return when (config) {
            MainNavigationConfig.Splash -> AppRoot.MainDestinationsChild.Splash(
                buildSplashComponent(componentContext)
            )
        }
    }

    private fun buildSplashComponent(
        context: ComponentContext
    ) = SplashComponentImpl(componentContext = context,
        onSplashTimeFinished = {
            mainDispatcher.launch {
            }
        })

    @Serializable
    sealed class MainNavigationConfig {
        @Serializable
        data object Splash : MainNavigationConfig()
    }
}