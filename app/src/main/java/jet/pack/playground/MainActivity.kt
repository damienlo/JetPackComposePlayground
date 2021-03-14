package jet.pack.playground

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import jet.pack.playground.ui.theme.JetPlaygroundTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPlaygroundTheme {
                MyApp()
            }
        }
    }
}


@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        AppNavGraph()
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
