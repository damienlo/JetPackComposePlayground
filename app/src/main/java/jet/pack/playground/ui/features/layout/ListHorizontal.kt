package jet.pack.playground.ui.features.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jet.pack.playground.ui.components.PlaygroundImage
import jet.pack.playground.ui.features.layout.model.DummyItem
import jet.pack.playground.ui.features.layout.model.dummyList
import jet.pack.playground.ui.theme.JetPlaygroundTheme

@Composable
fun ListHorizontal() {
    LazyRow(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        itemsIndexed(dummyList) { index, item ->
            Box(Modifier.padding(start = if (index == 0) 0.dp else 8.dp)) {
                CardItem(item)
            }
        }
    }
}

@Composable
private fun CardItem(item: DummyItem, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.width(128.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PlaygroundImage(
                uri = item.imageUrl,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentDescription = item.name
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = item.name,
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
fun LightPreviewHorizontalListItem() {
    JetPlaygroundTheme {
        CardItem(dummyList.first())
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewHorizontalListItem() {
    JetPlaygroundTheme(darkTheme = true) {
        CardItem(dummyList.first())
    }
}
