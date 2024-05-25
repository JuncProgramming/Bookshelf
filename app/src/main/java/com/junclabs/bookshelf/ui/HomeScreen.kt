package com.junclabs.bookshelf.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.junclabs.bookshelf.R

@Composable
fun HomeScreen(
    uiState: UiState, retryAction: () -> Unit, modifier: Modifier = Modifier
) {
    when (uiState) {
        is UiState.Success -> BookList(books = uiState.photos, modifier = modifier)
        is UiState.Loading -> LoadingScreen()
        is UiState.Error -> ErrorScreen(retryAction = retryAction)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BooksApp() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = { BooksTopAppBar(scrollBehavior = scrollBehavior) }) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                val booksViewModel: BookViewModel = viewModel(factory = BookViewModel.Factory)
                HomeScreen(
                    uiState = booksViewModel.uiState, retryAction = booksViewModel::getPhotos
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BooksTopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior, title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineSmall,
            )
        }, modifier = modifier
    )
}
