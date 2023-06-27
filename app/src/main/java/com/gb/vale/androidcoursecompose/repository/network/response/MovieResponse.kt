package com.gb.vale.androidcoursecompose.repository.network.response

import com.gb.vale.androidcoursecompose.model.MovieModel
import com.gb.vale.androidcoursecompose.utils.EMPTY
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("idMovie") val idMovie : String?,
    @SerializedName("title") val title : String?,
    @SerializedName("description") val description : String?
){
    fun toMovie()= MovieModel(idMovie = idMovie?:EMPTY,
        title = title?:EMPTY, description = description?:EMPTY)
}