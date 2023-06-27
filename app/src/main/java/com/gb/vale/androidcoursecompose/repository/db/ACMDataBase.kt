package com.gb.vale.androidcoursecompose.repository.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gb.vale.androidcoursecompose.repository.db.dao.UserDao
import com.gb.vale.androidcoursecompose.repository.db.entity.UserEntity

@Database(entities = [UserEntity::class],version = 1, exportSchema = false)
abstract class ACMDataBase : RoomDatabase(){

    abstract fun userDao() : UserDao

}