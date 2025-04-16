package org.kmp.playground.event.management.full.stack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.arkivanov.decompose.defaultComponentContext
import org.kmp.playground.event.management.full.stack.App.features.core.Core
import org.kmp.playground.event.management.full.stack.App.features.root.AppRootImpl

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val root = AppRootImpl(componentContext = defaultComponentContext())
        setContent {
            Core(root = root)
        }
    }
}