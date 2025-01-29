package com.aoeai.rg

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.aoeai.rg.common.ui.components.RgTabRow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    var currentScreen: Destination by remember { mutableStateOf(Home) }

    Scaffold(
        bottomBar = {
            RgTabRow(
                allScreens = rallyTabRowScreens,
                onTabSelected = { screen -> currentScreen = screen },
                currentScreen = currentScreen
            )
        }
    ) { innerPadding ->
        Box(Modifier.padding(innerPadding)) {
            currentScreen.screen()
        }
    }
}