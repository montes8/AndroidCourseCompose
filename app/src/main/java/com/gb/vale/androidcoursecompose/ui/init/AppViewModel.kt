package com.gb.vale.androidcoursecompose.ui.init

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.gb.vale.androidcoursecompose.ui.base.BaseViewModel
import com.gb.vale.androidcoursecompose.usecases.AppUseCase
import com.gb.vale.androidcoursecompose.usecases.UseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val appUseCase: AppUseCase, private val useUseCase: UseUseCase
):BaseViewModel() {


    private val _eventFlow = MutableSharedFlow<InitUiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()
    var uiToast by mutableStateOf(false)
    var uiToastRegister by mutableStateOf(false)

    fun loadValidateLogin(){
        execute {
            val response = appUseCase.getToken()
            delay(3000)
            _eventFlow.emit(InitUiEvent.NavigateToNext(response))
        }
    }


    fun login(user :String , pass : String){
        execute {
            val response = useUseCase.login(user,pass)
            uiToast = response==null
            _eventFlow.emit(InitUiEvent.NavigateToHome(response!=null))
        }
    }

    fun register(user :String , pass : String){
        execute {
            val response = useUseCase.register(user,pass)
            if (response){
                uiToastRegister = true
                _eventFlow.emit(InitUiEvent.NavigateToSuccess)
            }
        }
    }

    fun nextRegister(){
        execute {
            _eventFlow.emit(InitUiEvent.NavigateToRegister)
        }
    }

}