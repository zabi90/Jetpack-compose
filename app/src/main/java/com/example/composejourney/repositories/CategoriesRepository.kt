package com.example.composejourney.repositories

import com.example.composejourney.R
import com.example.composejourney.models.Category
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class CategoriesRepository @Inject constructor() {

    private var _categories_flow = MutableStateFlow<List<Category>>(emptyList())
    val categories: StateFlow<List<Category>> get() = _categories_flow

    suspend fun getCategories() {
        val _categories: MutableList<Category> = mutableListOf()
        _categories.add(Category("Burgers", R.drawable.burgers))
        _categories.add(Category("Grocery", R.drawable.grocery))
        _categories.add(Category("Salads", R.drawable.salads))
        _categories.add(Category("Sweets", R.drawable.sweets))
        _categories.add(Category("Utensils", R.drawable.utensils))
        delay(2000)
        _categories_flow.emit(_categories.toList())
    }
}