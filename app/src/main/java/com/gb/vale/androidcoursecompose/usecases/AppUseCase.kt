package com.gb.vale.androidcoursecompose.usecases

import com.gb.vale.androidcoursecompose.usecases.repository.preference.IAppPreferences
import com.gb.vale.androidcoursecompose.utils.EMPTY
import javax.inject.Inject

class AppUseCase @Inject constructor(private val iAppPreference : IAppPreferences) {
    fun logout() = iAppPreference.saveToken(EMPTY)
    fun getToken() = iAppPreference.getToken()

}