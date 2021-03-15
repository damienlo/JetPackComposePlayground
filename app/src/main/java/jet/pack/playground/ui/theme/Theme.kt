package jet.pack.playground.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = white,
    primaryVariant = catskillWhite,
    secondary = rust300,
    background = gray900,
    surface = white150,
    onPrimary = gray900,
    onSecondary = gray900,
    onBackground = taupe100,
    onSurface = white800
)

private val LightColorPalette = lightColors(
    primary = gray900,
    primaryVariant = corduroy,
    secondary = rust600,
    background = taupe100,
    surface = white850,
    onPrimary = white,
    onSecondary = white,
    onBackground = taupe800,
    onSurface = gray800
)

@Composable
fun JetPlaygroundTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}