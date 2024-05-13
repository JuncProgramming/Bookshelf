package com.junclabs.bookshelf.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.junclabs.bookshelf.BookApplication
import com.junclabs.bookshelf.data.BookRepository
import kotlinx.coroutines.launch

class BookViewModel(private val bookRepository: BookRepository): ViewModel() {
    var uiState: UiState by mutableStateOf(UiState.Loading)
        private set

    init {
        getPhotos()
    }

    fun getPhotos() {
        viewModelScope.launch {
            uiState = try {
                UiState.Success(bookRepository.getPhotos())
            } catch (e: Exception) {
                UiState.Error
            }
        }
    }

    fun getPhoto() {
        viewModelScope.launch {
            uiState = try {
                UiState.Success(photos = mutableListOf())
            } catch (e: Exception) {
                UiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as BookApplication)
                val bookRepository = application.container.bookRepository
                BookViewModel(bookRepository)
            }
        }
    }
}