package com.gb.vale.androidcoursecompose.repository.network.api

import com.gb.vale.androidcoursecompose.model.RecipeModel
import com.gb.vale.androidcoursecompose.repository.network.ACMService
import com.gb.vale.androidcoursecompose.repository.network.response.RecipeResponse
import com.gb.vale.androidcoursecompose.usecases.repository.network.IDataNetwork
import javax.inject.Inject

class DataNetwork @Inject constructor(private val acmService : ACMService) : IDataNetwork {

    override  suspend fun loadRecipes(): List<RecipeModel>{
        var data : List<RecipeModel>? = null
        val response = acmService.loadRecipes()
        if (response.isSuccessful){
            data = RecipeResponse.loadToRecipes(response.body()?:ArrayList())
        }
        return data?:throw Exception()
    }

}