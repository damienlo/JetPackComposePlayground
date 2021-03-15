package jet.pack.playground.ui.features.layout

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import jet.pack.playground.ui.components.FeatureCard


private object Routes {
    const val ListsAll = "list_all"
    const val ListVertical = "list_vertical"
    const val ListHorizontal = "list_horizontal"
    const val ListGrid = "list_grid"
}

private class Actions(navController: NavHostController) {
    val showListVertical: () -> Unit = {
        navController.navigate(Routes.ListVertical)
    }
    val showListHorizontal: () -> Unit = {
        navController.navigate(Routes.ListHorizontal)
    }
    val showListGrid: () -> Unit = {
        navController.navigate(Routes.ListGrid)
    }
}

@ExperimentalFoundationApi
@Composable
fun ListAndLayout() {
    val navController = rememberNavController()
    val actions = remember(navController) { Actions(navController) }

    NavHost(navController, startDestination = Routes.ListsAll) {
        composable(Routes.ListsAll) { ListAll(actions = actions) }
        composable(Routes.ListVertical) { ListVertical() }
        composable(Routes.ListHorizontal) { ListHorizontal() }
        composable(Routes.ListGrid) { ListGrid() }
    }
}

private enum class Layouts(val displayableName: String, val navigate: (Actions) -> Unit) {
    Vertical(displayableName = "Vertical", { action -> action.showListVertical() }),
    Horizontal(displayableName = "Horizontal", { action -> action.showListHorizontal() }),
    Grid(displayableName = "Grid", { action -> action.showListGrid() })
}

@Composable
private fun ListAll(actions: Actions) {
    LazyColumn(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        itemsIndexed(Layouts.values()) { index, layout ->
            Box(Modifier.padding(top = if (index == 0) 0.dp else 8.dp)) {
                FeatureCard(
                    featureName = layout.displayableName,
                    onClick = {
                        layout.navigate(actions)
                    })
            }
        }
    }
}
