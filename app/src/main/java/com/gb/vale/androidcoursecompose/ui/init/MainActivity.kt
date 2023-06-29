package com.gb.vale.androidcoursecompose.ui.init

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.gb.vale.androidcoursecompose.ui.init.splash.ScreenSplash
import com.gb.vale.androidcoursecompose.utils.AndroidCourseComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

   // private val viewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCourseComposeTheme {
                ScreenSplash(hiltViewModel())
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidCourseComposeTheme {
        ScreenSplash(hiltViewModel())
    }
}