package com.gb.vale.androidcoursecompose.ui.init.login

import android.app.Activity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gb.vale.androidcoursecompose.R
import com.gb.vale.androidcoursecompose.component.Screen
import com.gb.vale.androidcoursecompose.component.toast
import com.gb.vale.androidcoursecompose.ui.home.HomeActivity
import com.gb.vale.androidcoursecompose.ui.init.InitUiEvent
import com.gb.vale.androidcoursecompose.ui.init.AppViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ScreenLogin(viewModel: AppViewModel, navController: NavController) {

    val context = LocalContext.current
    val activity = (LocalContext.current as? Activity)

    var text by remember { mutableStateOf("tayler") }
    var textPass by remember { mutableStateOf("tayler") }
    var visibility by remember { mutableStateOf(false) }
    var revealPassword by remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current


    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is InitUiEvent.NavigateToRegister -> {
                    navController.navigate(Screen.RegisterScreen.route)
                }
                is InitUiEvent.NavigateToHome -> {
                    if (event.success)HomeActivity.newInstance(context)
                    activity?.finish()
                }
                else -> {}
            }
        }
    }

    if (viewModel.uiToast) {
        context.toast("Usuario incorrecto")
        viewModel.uiToast = false
    }

    val corountineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    var scrollToPosition by remember { mutableStateOf(0f) }



    Column(
        modifier = Modifier.verticalScroll(scrollState)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(modifier = Modifier.padding(top = 200.dp),
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
                viewModel.login(text,textPass)
            }) {
            Text(text = "Iniciar sesión", color = Color.White)
        }

        Text(modifier = Modifier
            .padding(top = 32.dp)
            .clickable { viewModel.nextRegister() },
            text = "Crear cuenta", color = Color.Blue,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            style = MaterialTheme.typography.body1
        )

        Text(modifier = Modifier
            .padding(top = 32.dp)
            .clickable { viewModel.nextRegister() },
            text = "Crear cuenta", color = Color.Blue,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            style = MaterialTheme.typography.body1
        )
        Text(modifier = Modifier
            .padding(top = 32.dp)
            .clickable { viewModel.nextRegister() },
            text = "Crear cuenta", color = Color.Blue,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            style = MaterialTheme.typography.body1
        )
        Text(modifier = Modifier.onGloballyPositioned {
            scrollToPosition = it.positionInRoot().y
        }
            .padding(top = 32.dp)
            .clickable { viewModel.nextRegister() },
            text = "Crear cuenta", color = Color.Blue,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            style = MaterialTheme.typography.body1
        )
        Text(modifier = Modifier
            .padding(top = 32.dp)
            .clickable { viewModel.nextRegister() },
            text = "Crear cuenta", color = Color.Blue,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            style = MaterialTheme.typography.body1
        )
        Text(modifier = Modifier
            .padding(top = 32.dp)
            .clickable { viewModel.nextRegister() },
            text = "Crear cuenta", color = Color.Blue,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            style = MaterialTheme.typography.body1
        )
        Text(modifier = Modifier
            .padding(top = 32.dp)
            .clickable { viewModel.nextRegister() },
            text = "Crear cuenta", color = Color.Blue,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            style = MaterialTheme.typography.body1
        )
        Text(modifier = Modifier
            .padding(top = 32.dp)
            .clickable { viewModel.nextRegister() },
            text = "Crear cuenta", color = Color.Blue,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            style = MaterialTheme.typography.body1
        )

    }
}