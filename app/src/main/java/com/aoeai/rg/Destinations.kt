package com.aoeai.rg

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.aoeai.rg.about.ui.About
import com.aoeai.rg.home.ui.Home

/**
 * Contract for information needed on every Rally navigation destination
 */
interface Destination {
    val icon: ImageVector
    val route: Int
    val screen: @Composable () -> Unit
}

/**
 * Rally app navigation destinations
 */
object Home : Destination {
    override val icon = Icons.Filled.Home
    override val route = R.string.local
    override val screen: @Composable () -> Unit = { Home() }
}

object Accounts : Destination {
    override val icon = Icons.Filled.Info
    override val route = R.string.about
    override val screen: @Composable () -> Unit = { About() }
}

// Screens to be displayed in the top RallyTabRow
val rallyTabRowScreens = listOf(Home, Accounts)
