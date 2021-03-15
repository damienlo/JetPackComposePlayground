package jet.pack.playground.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import jet.pack.playground.ui.home.features.HomeFeatureScreen
import jet.pack.playground.ui.home.settings.HomeSettingsScreen
import jet.pack.playground.ui.theme.JetPlaygroundTheme


private enum class BottomNavigationScreens(
    val title: String,
    val icon: ImageVector,
    val route: String
) {
    Feed("Feed", Icons.Filled.Home, NavRoutes.Feed),
    Settings("Feed", Icons.Filled.Settings, NavRoutes.Settings);

    fun navigateTo(actions: NavActions) {
        when (this) {
            Feed -> actions.showFeed()
            Settings -> actions.showSettings()
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    val actions = remember(navController) { NavActions(navController) }

    Scaffold(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxSize(),
        bottomBar = {
            BottomNavigation(
                backgroundColor = MaterialTheme.colors.background,
                elevation = 8.dp
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
                BottomNavigationScreens.values().forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(screen.icon, contentDescription = screen.title) },
                        label = { Text(screen.title) },
                        selected = currentRoute == screen.route,
                        onClick = { screen.navigateTo(actions = actions) }
                    )
                }
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            NavHost(navController, startDestination = NavRoutes.Feed) {
                composable(NavRoutes.Feed) { HomeFeatureScreen() }
                composable(NavRoutes.Settings) { HomeSettingsScreen() }
            }
        }
    }
}

private object NavRoutes {
    const val Feed = "feed"
    const val Settings = "settings"
}

private class NavActions(private val navController: NavHostController) {
    private fun isCurrentDestination(route: String) =
        route == navController.currentBackStackEntry?.arguments?.getString(KEY_ROUTE)

    private fun navigateSafe(route: String) {
        if (!isCurrentDestination(route)) {
            navController.navigate(route) {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo = navController.graph.startDestination
                // Avoid multiple copies of the same destination when
                // re-selecting the same item
                launchSingleTop = true
            }
        }
    }

    val showFeed: () -> Unit = {
        navigateSafe(NavRoutes.Feed)
    }
    val showSettings: () -> Unit = {
        navigateSafe(NavRoutes.Settings)
    }
}

@ExperimentalFoundationApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    JetPlaygroundTheme {
        HomeScreen()
    }
}

@ExperimentalFoundationApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    JetPlaygroundTheme(darkTheme = true) {
        HomeScreen()
    }
}

