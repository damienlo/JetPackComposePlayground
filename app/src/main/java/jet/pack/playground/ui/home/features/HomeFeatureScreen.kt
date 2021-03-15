package jet.pack.playground.ui.home.features

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import jet.pack.playground.ui.features.layout.ListAndLayout
import jet.pack.playground.ui.features.layout.ListHorizontal
import jet.pack.playground.ui.features.layout.ListVertical
import jet.pack.playground.ui.theme.JetPlaygroundTheme


private object Routes {
    const val AllFeatures = "all_features"

    // List & Layout
    const val ListAndLayout = "list_and_layout"
    const val ListHorizontal = "list_horizontal"
    const val ListVertical = "list_vertical"
    // Next?
}

private class Actions(navController: NavHostController) {
    val showListAndLayout: () -> Unit = {
        navController.navigate(Routes.ListAndLayout)
    }
    val showListHorizontal: () -> Unit = {
        navController.navigate(Routes.ListHorizontal)
    }
    val showListVertical: () -> Unit = {
        navController.navigate(Routes.ListVertical)
    }
}

@ExperimentalFoundationApi
@Composable
fun HomeFeaturesNavGraph(startDestination: String = Routes.AllFeatures) {
    val navController = rememberNavController()
    val actions = remember(navController) { Actions(navController) }

    NavHost(navController, startDestination = startDestination) {
        composable(Routes.AllFeatures) { HomeAllFeaturesScreen(actions.showListAndLayout) }
        // List & Layout
        composable(Routes.ListAndLayout) { ListAndLayout() }
        composable(Routes.ListHorizontal) { ListHorizontal() }
        composable(Routes.ListVertical) { ListVertical() }
    }
}

@ExperimentalFoundationApi
@Composable
fun HomeFeatureScreen() {
    HomeFeaturesNavGraph()
}

@ExperimentalFoundationApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeFeatureScreenLightPreview() {
    JetPlaygroundTheme {
        HomeFeatureScreen()
    }
}

@ExperimentalFoundationApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeFeatureScreenDarkPreview() {
    JetPlaygroundTheme(darkTheme = true) {
        HomeFeatureScreen()
    }
}

