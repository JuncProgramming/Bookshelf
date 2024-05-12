package com.junclabs.bookshelf.ui

import com.junclabs.bookshelf.model.BookPhoto

sealed interface UiState {
    data class Success(val photos: List<BookPhoto>) : UiState
    object Error : UiState
    object Loading : UiState
}