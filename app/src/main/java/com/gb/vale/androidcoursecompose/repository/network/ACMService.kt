package com.gb.vale.androidcoursecompose.repository.network

import com.gb.vale.androidcoursecompose.repository.network.response.RecipeResponse
import retrofit2.Response
import retrofit2.http.GET

interface ACMService {
    @GET("service/user/loadRecipes")
    suspend fun loadRecipes(): Response<List<RecipeResponse>>

}