package com.gb.vale.androidcoursecompose.repository.di

import com.gb.vale.androidcoursecompose.repository.db.api.UserDataBase
import com.gb.vale.androidcoursecompose.repository.network.api.DataNetwork
import com.gb.vale.androidcoursecompose.repository.preferences.api.AppPreferences
import com.gb.vale.androidcoursecompose.usecases.repository.db.IUserDataBase
import com.gb.vale.androidcoursecompose.usecases.repository.network.IDataNetwork
import com.gb.vale.androidcoursecompose.usecases.repository.preference.IAppPreferences
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ConfigMyModule{

    @Singleton
    @Binds
    abstract fun provideIUserDataBase(
        userDataBase: UserDataBase
    ): IUserDataBase

    @Singleton
    @Binds
    abstract fun provideIAppPreferences(
        appPreferences: AppPreferences
    ): IAppPreferences


    @Singleton
    @Binds
    abstract fun provideIDataNetwork(
        dataNetwork: DataNetwork
    ): IDataNetwork
}
