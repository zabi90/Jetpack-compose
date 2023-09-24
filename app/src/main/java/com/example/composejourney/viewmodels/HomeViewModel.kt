package com.example.composejourney.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composejourney.models.Category
import com.example.composejourney.repositories.CategoriesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val categoriesRepository: CategoriesRepository) :
    ViewModel() {

    val categories: StateFlow<List<Category>> get() = categoriesRepository.categories

    init {
        viewModelScope.launch {
            categoriesRepository.getCategories()
        }
    }
}