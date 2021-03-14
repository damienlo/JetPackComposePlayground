package jet.pack.playground.ui.features.profiles.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import jet.pack.playground.ui.theme.JetPlaygroundTheme

@Composable
fun ProfileDetailsScreen(userId: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    JetPlaygroundTheme {
        ProfileDetailsScreen("userId")
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    JetPlaygroundTheme(darkTheme = true) {
        ProfileDetailsScreen("userId")
    }
}
