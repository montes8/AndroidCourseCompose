package com.gb.vale.androidcoursecompose.usecases

import com.gb.vale.androidcoursecompose.usecases.repository.network.IDataNetwork
import javax.inject.Inject

class DataUseCase @Inject constructor(private val iDataNetwork : IDataNetwork
) {
    suspend fun loadRecipes() = iDataNetwork.loadRecipes()

}