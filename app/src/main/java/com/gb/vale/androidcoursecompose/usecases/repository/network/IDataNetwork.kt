package com.gb.vale.androidcoursecompose.usecases.repository.network

import com.gb.vale.androidcoursecompose.model.RecipeModel


interface IDataNetwork {
     suspend fun loadRecipes( ): List<RecipeModel>

}