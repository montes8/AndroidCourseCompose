package com.gb.vale.androidcoursecompose.ui.init.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gb.vale.androidcoursecompose.R
import com.gb.vale.androidcoursecompose.component.Screen
import com.gb.vale.androidcoursecompose.ui.init.splash.InitUiEvent
import com.gb.vale.androidcoursecompose.ui.init.splash.SplashViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ScreenLogin(viewModel: SplashViewModel, navController: NavController) {

    var text by remember { mutableStateOf("") }

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is InitUiEvent.NavigateToNext -> {
                    navController.navigate(Screen.LoginScreen.route)
                }
                else -> {}
            }
        }
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = text,
            shape = RoundedCornerShape(8.dp),
            onValueChange = { text = it },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = colorResource(id = R.color.gray),
                focusedIndicatorColor = Color.Blue,
                cursorColor = Color.Blue,
                disabledLabelColor = colorResource(id = R.color.gray_150),
                unfocusedIndicatorColor = colorResource(id = R.color.gray_100)
            ),
            label = { Text("Usuario") }
        )

        OutlinedTextField(modifier = Modifier.padding(top = 10.dp),
            value = "",
            shape = RoundedCornerShape(8.dp),
            onValueChange = { text = it },
            label = { Text("Contraseña") }
        )

        Button(modifier = Modifier
            .height(66.dp)
            .padding(top = 24.dp),
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(1.dp, Color.Black),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
            onClick = {

            }) {
            Text(text = "Iniciar sesión", color = Color.White)
        }

    }
}