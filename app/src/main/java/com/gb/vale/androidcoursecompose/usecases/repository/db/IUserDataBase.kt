package com.gb.vale.androidcoursecompose.usecases.repository.db

import com.gb.vale.androidcoursecompose.model.User

interface IUserDataBase {

    fun insertUserDb(user : String, pass : String):Boolean

    fun login(user : String , pass : String) : User?

}