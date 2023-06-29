package com.gb.vale.androidcoursecompose.ui.init.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gb.vale.androidcoursecompose.R
import com.gb.vale.androidcoursecompose.ui.home.HomeActivity
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ScreenSplash(viewModel: SplashViewModel){

    val context = LocalContext.current
    viewModel.loadValidateLogin()

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is SplashUiEvent.NavigateToNext -> { HomeActivity.newInstance(context) }
                else ->  {} } }
    }

    Column(modifier = Modifier.fillMaxSize().
    paint(
        painterResource(id = R.drawable.background_splash),contentScale
    = ContentScale.FillBounds
    ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(  horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = stringResource(R.string.text_sub_title_splash)
                , color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                style = MaterialTheme.typography.body1
            )
            Text(modifier = Modifier.padding(top = 10.dp), text = stringResource(R.string.test_number),color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                style = MaterialTheme.typography.body1)
        }
        Text(modifier = Modifier.padding(top = 10.dp),text = stringResource(R.string.text_welcome),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            style = MaterialTheme.typography.body1)
    }
}