package com.gb.vale.androidcoursecompose.repository.db.api

import com.gb.vale.androidcoursecompose.model.User
import com.gb.vale.androidcoursecompose.repository.db.dao.UserDao
import com.gb.vale.androidcoursecompose.repository.db.entity.UserEntity
import com.gb.vale.androidcoursecompose.usecases.repository.db.IUserDataBase
import javax.inject.Inject

class UserDataBase @Inject constructor(private val iUserDao : UserDao): IUserDataBase {

    override
    fun insertUserDb(user : String, pass : String):Boolean{
        val response = iUserDao.insert(UserEntity(name= user,pass = pass,token = "sdfghj"))
        return response != null
    }

    override
    fun login(user : String , pass : String) : User? {
        val userDb = iUserDao.userLogin(user,pass)
        return userDb?.toUser()
    }
}