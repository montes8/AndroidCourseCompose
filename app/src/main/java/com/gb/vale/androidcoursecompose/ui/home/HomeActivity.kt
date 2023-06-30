package com.gb.vale.androidcoursecompose.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gb.vale.androidcoursecompose.R
import com.gb.vale.androidcoursecompose.component.CircleAvatar
import com.gb.vale.androidcoursecompose.model.RecipeModel
import com.gb.vale.androidcoursecompose.utils.AndroidCourseComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    private val viewModel: HomeViewModel by viewModels()
    companion object{
        fun newInstance(context: Context) = context.startActivity(Intent(context,HomeActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCourseComposeTheme {
                Box{
                    Column( modifier = Modifier.padding(20.dp)){
                        ListInitialRecipes(viewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun ListInitialRecipes(
    viewModel: HomeViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (viewModel.uiState.recipes.isNotEmpty()) {

            Text(
                text =  "Lista de recetas",
                modifier = Modifier.padding(12.dp),
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.Medium,
                maxLines = 1,
                color = colorResource(id = R.color.blue)
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(viewModel.uiState.recipes) { recipe ->
                    RecipesItem(
                        recipe = recipe,
                        openNewChatAction = {
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun RecipesItem(
    recipe: RecipeModel,
    openNewChatAction: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(20.dp),elevation = 10.dp,
        backgroundColor = MaterialTheme.colors.surface,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { openNewChatAction() }
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircleAvatar(image = recipe.urlImg)
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = recipe.title,
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = recipe.description,
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.55f),
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis
                )

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