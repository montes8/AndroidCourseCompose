package com.gb.vale.androidcoursecompose.ui.init.splash

import com.gb.vale.androidcoursecompose.ui.base.BaseViewModel
import com.gb.vale.androidcoursecompose.usecases.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val appUseCase: AppUseCase
):BaseViewModel() {


    private val _eventFlow = MutableSharedFlow<InitUiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()


    fun loadValidateLogin(){
        execute {
            val response = appUseCase.getToken()
            delay(3000)
            _eventFlow.emit(InitUiEvent.NavigateToNext(response))
        }
    }

    fun nextHome(){
        execute {
            _eventFlow.emit(InitUiEvent.NavigateToHome)
        }
    }

    fun login(user :String , pass : String){
        execute {
            _eventFlow.emit(InitUiEvent.NavigateToLogin(user,pass))
        }
    }

    fun register(){
        execute {
            _eventFlow.emit(InitUiEvent.NavigateToRegister)
        }
    }

}