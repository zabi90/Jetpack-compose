package com.example.composejourney.repositories

import com.example.composejourney.R
import com.example.composejourney.models.Category
import com.example.composejourney.models.Outlet
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CategoriesRepository @Inject constructor() {

    private var _categories_flow = MutableStateFlow<List<Category>>(emptyList())

//    suspend fun getCategories() : StateFlow<List<Category>> {
//        val _categories: MutableList<Category> = mutableListOf()
//        _categories_flow.emit(emptyList())
//        _categories.add(Category("Burgers", R.drawable.burgers))
//        _categories.add(Category("Grocery", R.drawable.grocery))
//        _categories.add(Category("Salads", R.drawable.salads))
//        _categories.add(Category("Sweets", R.drawable.sweets))
//        _categories.add(Category("Utensils", R.drawable.utensils))
//        delay(5000)
//        _categories_flow.emit(_categories.toList())
//        return  _categories_flow
//    }

    suspend fun getCategories() = flow {
        val _categories: MutableList<Category> = mutableListOf()
        _categories.add(Category("Burgers", R.drawable.burgers))
        _categories.add(Category("Grocery", R.drawable.grocery))
        _categories.add(Category("Salads", R.drawable.salads))
        _categories.add(Category("Sweets", R.drawable.sweets))
        _categories.add(Category("Utensils", R.drawable.utensils))
        delay(2000)
        emit(_categories.toList())

    }

    suspend fun getOutlets() = flow {
        val _outlets: MutableList<Outlet> = mutableListOf()
        _outlets.add(Outlet("KFC", R.drawable.kfc,R.drawable.kfc_banner))
        _outlets.add(Outlet("Harvey", R.drawable.harvey,R.drawable.rectangle_burgers))

        delay(3000)
        emit(_outlets.toList())

    }
}