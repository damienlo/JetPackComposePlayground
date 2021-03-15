package jet.pack.playground.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PlaygroundImage(
    uri: String,
    modifier: Modifier = Modifier,
    contentDescription: String? = null
) {
    CoilImage(
        data = uri,
        modifier = modifier,
        contentDescription = contentDescription,
        loading = { PlayGroundImageLoadingState() },
        error = { PlayGroundImageErrorState() }
    )
}

@Composable
private fun PlayGroundImageLoadingState() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun PlayGroundImageErrorState() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.error),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Error!",
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.onError,
            modifier = Modifier.padding(8.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}