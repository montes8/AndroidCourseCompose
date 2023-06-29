package com.gb.vale.androidcoursecompose.ui.init.splash

sealed class SplashUiEvent {
    object NavigateToFinish : SplashUiEvent()
    class NavigateToNext(value : Boolean) : SplashUiEvent()
}