package com.gb.vale.androidcoursecompose.ui.init

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.gb.vale.androidcoursecompose.component.navigation.Navigation
import com.gb.vale.androidcoursecompose.utils.AndroidCourseComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCourseComposeTheme {
                Navigation()
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidCourseComposeTheme {
    }
}