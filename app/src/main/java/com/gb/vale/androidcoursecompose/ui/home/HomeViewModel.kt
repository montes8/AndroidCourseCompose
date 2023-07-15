package com.gb.vale.androidcoursecompose.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.gb.vale.androidcoursecompose.model.RecipeModel
import com.gb.vale.androidcoursecompose.ui.base.BaseViewModel
import com.gb.vale.androidcoursecompose.usecases.DataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dataUseCase: DataUseCase
):BaseViewModel() {


    var uiStateListRecipes by mutableStateOf(listOf<RecipeModel>())

    var uiStateLoading by mutableStateOf(true)

    init {
        execute {
            delay(500)
            loadRecipes()
        }
    }

    fun loadRecipes() {
        execute {
            uiStateLoading = true
            val response =  dataUseCase.loadRecipes()
            uiStateListRecipes = response
            uiStateLoading = false
        }
    }

}