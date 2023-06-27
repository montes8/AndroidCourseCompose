package com.gb.vale.androidcoursecompose.usecases.repository.network

import com.gb.vale.androidcoursecompose.model.MovieModel


interface IDataNetwork {
     suspend fun loadMovie( ): MovieModel

}