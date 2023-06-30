package com.gb.vale.androidcoursecompose.ui.home

import com.gb.vale.androidcoursecompose.model.RecipeModel

data class RecipesUiState(
    var recipes: List<RecipeModel> = emptyList(),
)
