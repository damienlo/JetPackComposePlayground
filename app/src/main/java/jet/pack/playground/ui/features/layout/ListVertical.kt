package jet.pack.playground.ui.features.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jet.pack.playground.ui.components.PlaygroundImage
import jet.pack.playground.ui.features.layout.model.DummyItem
import jet.pack.playground.ui.features.layout.model.dummyList
import jet.pack.playground.ui.theme.JetPlaygroundTheme

@Composable
fun ListVertical() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        itemsIndexed(dummyList) { index, item ->
            Box(Modifier.padding(top = if (index == 0) 0.dp else 8.dp)) {
                CardItem(item)
            }
        }
    }
}

@Composable
private fun CardItem(item: DummyItem, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            PlaygroundImage(
                uri = item.imageUrl,
                modifier = Modifier.size(96.dp),
                contentDescription = item.name
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = item.name,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.padding(8.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewCard() {
    JetPlaygroundTheme {
        CardItem(dummyList.first())
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewCard() {
    JetPlaygroundTheme(darkTheme = true) {
        CardItem(dummyList.first())
    }
}
