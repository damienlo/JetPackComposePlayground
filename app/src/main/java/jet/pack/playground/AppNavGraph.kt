package jet.pack.playground

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import jet.pack.playground.ui.features.home.HomeScreen
import jet.pack.playground.ui.features.login.LoginScreen
import jet.pack.playground.ui.features.splash.SplashScreen


private object Routes {
    const val Splash = "splash"
    const val Login = "login"
    const val Home = "home"
}

private class Actions(navController: NavHostController) {
    val showLogin: () -> Unit = {
        navController.navigate(Routes.Login)
    }
    val showHome: () -> Unit = {
        navController.navigate(Routes.Home)
    }
}

@Composable
fun AppNavGraph(startDestination: String = Routes.Splash) {
    val navController = rememberNavController()
    val actions = remember(navController) { Actions(navController) }

    NavHost(navController, startDestination = startDestination) {
        composable(Routes.Splash) { SplashScreen(appLoaded = actions.showLogin) }
        composable(Routes.Login) { LoginScreen(loggedIn = actions.showHome) }
        composable(Routes.Home) { HomeScreen() }
    }
}
