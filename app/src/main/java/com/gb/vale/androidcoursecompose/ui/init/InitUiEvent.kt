package com.gb.vale.androidcoursecompose.ui.init

sealed class InitUiEvent {
    class NavigateToNext(value : Boolean) : InitUiEvent()

    class NavigateToHome(var success : Boolean)  : InitUiEvent()

    object NavigateToSuccess : InitUiEvent()
    object NavigateToRegister : InitUiEvent()
}