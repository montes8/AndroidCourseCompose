package com.gb.vale.androidcoursecompose.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gb.vale.androidcoursecompose.R
import com.gb.vale.androidcoursecompose.utils.AndroidCourseComposeTheme

class HomeActivity : ComponentActivity() {

    companion object{
        fun newIntance(context: Context) = context.startActivity(Intent(context,HomeActivity::class.java))
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