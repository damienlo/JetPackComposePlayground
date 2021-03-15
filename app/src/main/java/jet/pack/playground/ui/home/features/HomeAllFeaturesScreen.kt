package jet.pack.playground.ui.home.features

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jet.pack.playground.ui.components.FeatureCard
import jet.pack.playground.ui.theme.JetPlaygroundTheme

private enum class Features(val displayableName: String) {
    ListAndLayout(displayableName = "List & Layout")
}

@Composable
fun HomeAllFeaturesScreen(
    showListAndLayoutFeature: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxSize(),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(Features.values()) { feature ->
            FeatureCard(featureName = feature.displayableName, onClick = showListAndLayoutFeature)
        }
    }
}


@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeAllFeaturesScreenLightPreview() {
    JetPlaygroundTheme {
        HomeAllFeaturesScreen {}
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeAllFeaturesScreenDarkPreview() {
    JetPlaygroundTheme(darkTheme = true) {
        HomeAllFeaturesScreen {}
    }
}

