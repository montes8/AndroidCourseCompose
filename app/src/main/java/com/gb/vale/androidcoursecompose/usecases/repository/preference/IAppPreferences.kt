package com.gb.vale.androidcoursecompose.usecases.repository.preference

interface IAppPreferences {
    fun saveToken(value : String )

    fun getToken() : Boolean

}