package com.gb.vale.androidcoursecompose.usecases

import com.gb.vale.androidcoursecompose.model.User
import com.gb.vale.androidcoursecompose.usecases.repository.db.IUserDataBase
import com.gb.vale.androidcoursecompose.usecases.repository.preference.IAppPreferences
import javax.inject.Inject

class UseUseCase @Inject constructor(private val iAppPreference : IAppPreferences,
                                     private val iUserDataBase : IUserDataBase
) {

    fun login(user : String , pass : String) : User?{
        val response = iUserDataBase.login(user,pass)
        if (response != null)saveToken(response.token)
        return response
    }

    fun register(user : String , pass : String):Boolean = iUserDataBase.insertUserDb(user,pass)

    private fun saveToken(value : String ) = iAppPreference.saveToken(value)

}