package com.gb.vale.androidcoursecompose.repository.preferences.api

import com.gb.vale.androidcoursecompose.repository.preferences.manager.PreferencesManager
import com.gb.vale.androidcoursecompose.usecases.repository.preference.IAppPreferences
import com.gb.vale.androidcoursecompose.utils.PREFERENCE_TOKEN
import javax.inject.Inject

class AppPreferences @Inject constructor(private val preferenceManager : PreferencesManager):
    IAppPreferences {

    override fun saveToken(value : String ) = preferenceManager.setValue(PREFERENCE_TOKEN,value)

    override fun getToken() = preferenceManager.getString(PREFERENCE_TOKEN).isNotEmpty()
}