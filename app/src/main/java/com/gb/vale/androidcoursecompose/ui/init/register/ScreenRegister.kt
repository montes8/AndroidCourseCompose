package com.gb.vale.androidcoursecompose.ui.init.register

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gb.vale.androidcoursecompose.R
import com.gb.vale.androidcoursecompose.component.toast
import com.gb.vale.androidcoursecompose.ui.init.AppViewModel
import com.gb.vale.androidcoursecompose.ui.init.InitUiEvent
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ScreenRegister (viewModel: AppViewModel, navController: NavController) {

    val context = LocalContext.current
    var text by remember { mutableStateOf("tayler") }
    var textPass by remember { mutableStateOf("tayler") }
    var visibility by remember { mutableStateOf(false) }
    var revealPassword by remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is InitUiEvent.NavigateToSuccess -> {
                    navController.popBackStack()
                }
                else -> {}
            }
        }
    }

    if (viewModel.uiToastRegister) {
        context.toast("Usuario Registrado")
        viewModel.uiToastRegister = false
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = text,
            shape = RoundedCornerShape(12.dp),
            onValueChange = { text = it },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Blue,
                cursorColor = Color.Blue,
                disabledLabelColor = colorResource(id = R.color.gray_150),
                unfocusedIndicatorColor = colorResource(id = R.color.gray_100)
            ),
            label = { Text("Usuario") }
        )

        OutlinedTextField(modifier = Modifier.padding(top = 24.dp),
            value = textPass,
            shape = RoundedCornerShape(12.dp),
            onValueChange = { textPass = it },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = colorResource(id = R.color.blue),
                cursorColor = colorResource(id = R.color.blue),
                disabledLabelColor = colorResource(id = R.color.gray_150),
                unfocusedIndicatorColor = colorResource(id = R.color.gray_100)
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {keyboardController?.hide()}
            ),
            visualTransformation = if (visibility)
                VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                if (revealPassword) {
                    IconButton(
                        onClick = {
                            revealPassword = false
                            visibility = false
                        },
                    ) {
                        Icon(imageVector = Icons.Filled.Visibility, contentDescription = null)
                    }
                } else {
                    IconButton(
                        onClick = {
                            revealPassword = true
                            visibility = true
                        },
                    ) {

                        Icon(imageVector = Icons.Filled.VisibilityOff, contentDescription = null)
                    }
                }
            },
            label = { Text("Contraseña") }
        )

        Button(modifier = Modifier
            .height(66.dp)
            .padding(top = 24.dp),
            shape = RoundedCornerShape(32.dp),
            border = BorderStroke(1.dp, Color.Black),
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.blue)),
            onClick = {
                viewModel.register(text,textPass)
            }) {
            Text(text = "Registrarse", color = Color.White)
        }


    }
}