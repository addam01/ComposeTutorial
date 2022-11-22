package com.addam.jetpackcomposetutorial

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.addam.jetpackcomposetutorial.features.login.LoginActivity
import com.addam.jetpackcomposetutorial.features.posts.PostsActivity
import com.addam.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationButtons()
                }
            }
        }
    }
}

@Composable
private fun NavigationButtons(){
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxWidth()
    ){
        Button(
            onClick = {
                      context.startActivity(Intent(context, LoginActivity::class.java))
            },
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ){ Text(stringResource(R.string.login_form)) }

        Spacer(modifier = Modifier.padding(16.dp))

        Button(
            onClick = {
                context.startActivity(Intent(context, PostsActivity::class.java))
            },
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ){ Text(stringResource(R.string.post_api)) }
    }
}