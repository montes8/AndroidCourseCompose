package com.gb.vale.androidcoursecompose.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.gb.vale.androidcoursecompose.ui.base.BaseViewModel
import com.gb.vale.androidcoursecompose.usecases.AppUseCase
import com.gb.vale.androidcoursecompose.usecases.DataUseCase
import com.gb.vale.androidcoursecompose.usecases.UseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dataUseCase: DataUseCase
):BaseViewModel() {


    var uiState by mutableStateOf(RecipesUiState())

    init {
        execute {
            delay(500)
            loadRecipes()
        }
    }

    fun loadRecipes() {
        execute {
            val response =  dataUseCase.loadRecipes()
            uiState = uiState.copy(recipes = response)
        }
    }

}