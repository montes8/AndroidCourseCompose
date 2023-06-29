package com.gb.vale.androidcoursecompose.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.gb.vale.androidcoursecompose.utils.AndroidCourseComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    companion object{
        fun newInstance(context: Context) = context.startActivity(Intent(context,HomeActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCourseComposeTheme {
                Text(text = "Hola home")
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