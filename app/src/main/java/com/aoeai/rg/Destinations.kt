package com.aoeai.rg

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.aoeai.rg.home.ui.Home
import com.aoeai.rg.ui.overview.AccountsScreen

/**
 * Contract for information needed on every Rally navigation destination
 */
interface Destination {
    val icon: ImageVector
    val route: String
    val screen: @Composable () -> Unit
}

/**
 * Rally app navigation destinations
 */
object Home : Destination {
    override val icon = Icons.Filled.Home
    override val route = ""
    override val screen: @Composable () -> Unit = { Home() }
}

object Accounts : Destination {
    override val icon = Icons.Filled.Info
    override val route = ""
    override val screen: @Composable () -> Unit = { AccountsScreen() }
}

// Screens to be displayed in the top RallyTabRow
val rallyTabRowScreens = listOf(Home, Accounts)
