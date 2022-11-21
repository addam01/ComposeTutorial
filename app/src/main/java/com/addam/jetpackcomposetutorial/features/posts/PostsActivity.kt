package com.addam.jetpackcomposetutorial.features.posts

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.addam.jetpackcomposetutorial.models.PostResponse
import com.addam.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostsActivity : ComponentActivity() {
    private val viewModel: PostsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Add list here
                    EmployeeContent(viewModel)
                }
            }
        }
    }
}

@Composable
private fun EmployeeContent(viewModel: PostsViewModel){
    val data: List<PostResponse> = viewModel.data
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(
            onClick = {viewModel.getEmployees()},
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .padding(30.dp)
                .fillMaxWidth()
        ){
            Text("Call Posts")
        }
        if(data.isNotEmpty()){
            Log.d("Post", data.toString())
            EmployeeList(data)
        }
    }
}

@Composable
fun EmployeeList(
    res: List<PostResponse>
) {
    LazyColumn(
        modifier = Modifier
    ){
        items(
            items = res
        ){item ->
            EmployeeItem(item)
        }
    }
}

@Composable
fun EmployeeItem(item: PostResponse){
    Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
        Text(text = item.title)
    }
}
