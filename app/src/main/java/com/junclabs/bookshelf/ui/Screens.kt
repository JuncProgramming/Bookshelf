package com.junclabs.bookshelf.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.junclabs.bookshelf.model.BookPhoto

@Composable
fun BookCard(book: BookPhoto) {
    Card {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
            .data(book.volumeInfo.imageLinks.httpsThumbnail)
            .crossfade(true)
            .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun BookList(
    books: List<BookPhoto>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(8.dp),
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.padding(horizontal = 8.dp),
        contentPadding = contentPadding,
    ) {
        items(items = books, key = { book -> book.hashCode() }) { book ->
            BookCard(book = book)
        }
    }
}

@Composable
fun LoadingScreen() {
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Ladowanie...")
    }
}

@Composable
fun ErrorScreen(retryAction: () -> Unit) {
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Dupa", modifier = Modifier.padding(16.dp))
        Button(onClick = retryAction) {
            Text("Spróbuj ponownie")
        }
    }
}