package com.miguelzamit.signinmiguel.ui.screens

import android.icu.util.Calendar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miguelzamit.signinmiguel.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignIn(modifier: Modifier){

    var name: String by rememberSaveable { mutableStateOf("") }
    var firstSurname: String by rememberSaveable { mutableStateOf("") }
    var secondSurname: String by rememberSaveable { mutableStateOf("") }
    var email: String by rememberSaveable { mutableStateOf("") }
    var phone: Int by rememberSaveable { mutableIntStateOf(0) }
    var date = rememberDatePickerState(initialSelectedDateMillis = Calendar.getInstance().timeInMillis)

    Column (
        modifier = modifier
    ){
        Column (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){


            Text(
                text = "Sign In",
                fontSize = 60.sp,
                fontWeight = FontWeight.Black
            )

            Spacer(modifier = Modifier.height(30.dp))
            // Nombre
            MyTextField(
                value = name,
                onValueChange = {name = it},
                label = { Text("Name") },
                option = 1
            )

            // Esto es el final
            Spacer(modifier = Modifier.height(60.dp))
            Row (
                modifier = Modifier
                    .height(1.dp)
                    .width(300.dp)
                    .background(Color.Black)

            ){  }
            Spacer(modifier = Modifier.height(30.dp))
            Author()
        }
    }


}

@Composable
fun MyTextField(value: String, option: Int, label: @Composable () -> Unit, onValueChange: (String) -> Unit){

    var passVisibleState by rememberSaveable { mutableStateOf(false) }

    when(option){
        1 -> { // Texto normal
            OutlinedTextField(
                value = value,
                onValueChange = {onValueChange(value)},
                label = label,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next
                )
            )
        }

        2 -> { // Password
            OutlinedTextField(
                value = value,
                onValueChange = {onValueChange(value)},
                label = label,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next
                ),
                trailingIcon = {
                    val icon = if (passVisibleState){
                        Icons.Default.
                    }
                }
            )
        }

        3 -> { // Numeros
            OutlinedTextField(
                value = value,
                onValueChange = {onValueChange(value)},
                label = label,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next
                )
            )
        }

    }

}

@Composable
fun Author(){

    Row (){
        Image(
            painter = painterResource(id = R.drawable.foto),
            contentDescription = "Author",
            modifier = Modifier
                .clip(CircleShape)
                .size(80.dp)
                .border(
                    width = 2.dp,
                    color = Color.White,
                    shape = CircleShape
                )
        )

        Column (
            modifier = Modifier
                .padding(15.dp)
        ){
            Text(
                text = "Miguel",
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Black,
                lineHeight = 3.sp
            )

            Text(
                text = "2024 - 2025",
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Black,
                lineHeight = 3.sp

            )
        }


    }

}