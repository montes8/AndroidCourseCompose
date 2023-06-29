package com.gb.vale.androidcoursecompose.ui.init.splash

sealed class InitUiEvent {
    object NavigateToFinish : InitUiEvent()
    class NavigateToNext(value : Boolean) : InitUiEvent()

    object NavigateToHome : InitUiEvent()

    class NavigateToLogin(user : String , pass : String) : InitUiEvent()
    object NavigateToRegister : InitUiEvent()
}