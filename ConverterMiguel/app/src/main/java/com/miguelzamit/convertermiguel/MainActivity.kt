package com.miguelzamit.convertermiguel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miguelzamit.convertermiguel.ui.theme.ConverterMiguelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConverterMiguelTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Converter(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Converter(modifier: Modifier){
    Column (
        modifier = modifier
    ){
        Column (
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.foto),
                contentDescription = "Miguel",
                modifier = Modifier
                    .clip(CircleShape)
                    .border(
                        width = 5.dp,
                        color = Color.White,
                        shape = CircleShape
                    )
            )
        }
    }
}