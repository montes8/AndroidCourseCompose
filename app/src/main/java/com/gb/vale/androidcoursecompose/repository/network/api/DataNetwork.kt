package com.gb.vale.androidcoursecompose.repository.network.api

import com.gb.vale.androidcoursecompose.model.MovieModel
import com.gb.vale.androidcoursecompose.repository.exeption.GenericError
import com.gb.vale.androidcoursecompose.repository.network.ACMService
import com.gb.vale.androidcoursecompose.usecases.repository.network.IDataNetwork
import javax.inject.Inject

class DataNetwork @Inject constructor(private val acmService : ACMService) : IDataNetwork {

    override  suspend fun loadMovie(): MovieModel {
        var data : MovieModel? = null
       val response = acmService.loadMovie()
        if (response.isSuccessful){
            data = response.body()?.toMovie()
        }
        return data?:throw GenericError("error servicio")
    }

}