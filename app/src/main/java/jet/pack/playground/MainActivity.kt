package jet.pack.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets
import jet.pack.playground.ui.theme.JetPlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This app draws behind the system bars, so we want to handle fitting system windows
//         WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            JetPlaygroundTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    ProvideWindowInsets {
        Surface(color = MaterialTheme.colors.background) {
            AppNavGraph()
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    JetPlaygroundTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    JetPlaygroundTheme(darkTheme = true) {
        MyApp()
    }
}
