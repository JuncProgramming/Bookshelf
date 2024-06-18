package com.junclabs.bookshelf.ui

import com.junclabs.bookshelf.model.BookVolumes

sealed interface UiState {
    data class Success(val photos: BookVolumes) : UiState
    data object Error : UiState
    data object Loading : UiState
}