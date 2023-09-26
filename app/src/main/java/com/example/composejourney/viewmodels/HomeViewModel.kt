package com.example.composejourney.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composejourney.models.Category
import com.example.composejourney.models.Outlet
import com.example.composejourney.repositories.CategoriesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val categoriesRepository: CategoriesRepository) :
    ViewModel() {

    //States
    private var _categories : MutableState<List<Category>> = mutableStateOf(emptyList())
    val categories : State<List<Category>> get() = _categories

    private var _isLoading : MutableState<Boolean> = mutableStateOf(false)
    val isLoading : State<Boolean> get() = _isLoading


    private var _outlets : MutableState<List<Outlet>> = mutableStateOf(emptyList())
    val outlets : State<List<Outlet>> get() = _outlets

    private var _isLoadingOutlet : MutableState<Boolean> = mutableStateOf(false)
    val isLoadingOutlet : State<Boolean> get() = _isLoadingOutlet



    init {
        viewModelScope.launch {
            categoriesRepository
                .getCategories()
                .onStart {
                    _isLoading.value = true
                }
                .onCompletion {
                    _isLoading.value = false
                }
                .catch {
                }
                .collect{
                    _categories.value = it
                }

        }

        viewModelScope.launch {

            categoriesRepository
                .getOutlets()
                .onStart {
                    _isLoadingOutlet.value = true
                }
                .onCompletion {
                    _isLoadingOutlet.value = false
                }
                .catch {
                }
                .collect{
                    _outlets.value = it
                }
        }
    }
}