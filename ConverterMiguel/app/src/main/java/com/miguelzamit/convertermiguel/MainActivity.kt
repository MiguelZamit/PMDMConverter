package com.miguelzamit.convertermiguel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

// Si no va ponerle el Composable
fun ConvertToBinaryOrDecimal(value: String, interruptorValue: Boolean): String {
    // Si esta false binario si esta true decimal
    return try {
        var aux = value.toInt()
        if (interruptorValue) {
            val binaryNumbers = mutableListOf<Int>()
            while (aux > 0) {
                binaryNumbers.add(aux % 2)
                aux /= 2
            }

            binaryNumbers.asReversed().joinToString("")
        } else {
            aux.toInt().toDouble().toString()
        }
    } catch (e: Exception) {
        "Entrada inválida: $value"
    }

}

@Composable
fun Converter(modifier: Modifier){

    var valueNumber: String by rememberSaveable { mutableStateOf("") }
    var interruptorVar: Boolean by rememberSaveable { mutableStateOf(false) }
    var result: String by rememberSaveable { mutableStateOf("") }

    Column (
        modifier = modifier
    ){
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row (){
                Image(
                    painter = painterResource(id = R.drawable.foto),
                    contentDescription = "Miguel",
                    modifier = Modifier
                        .clip(CircleShape)
                        .border(
                            width = 2.dp,
                            color = Color.Black,
                            shape = CircleShape
                        )
                        .size(100.dp)
                )

                Text(
                    text = "Miguel Zamit",
                    modifier = Modifier
                        .padding(30.dp),
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Row (
                modifier = Modifier
                    .width(300.dp)
                    .height(1.dp)
                    .background(Color.Black)

            ){}

            Spacer(modifier = Modifier.height(30.dp))
            OutlinedTextField(
                value = valueNumber,
                onValueChange = { valueNumber = it },
                label = {Text("Introduce un numero")},
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Done
                )
            )

            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = """
                    Activa para transformalo a binario
                    Dejalo para dejarlo en decimal
                """.trimIndent(),
                fontWeight = FontWeight.Black
            )
            Spacer(modifier = Modifier.height(30.dp))
            Switch(
                checked = interruptorVar,
                onCheckedChange = { interruptorVar = it }
            )

            Spacer(modifier = Modifier.height(60.dp))
            Text(
                text = result,
                fontSize = 70.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.horizontalScroll(rememberScrollState())
            )

            Spacer(modifier = Modifier.height(60.dp))
            Button(
                onClick = {
                    result = ConvertToBinaryOrDecimal(valueNumber, interruptorVar)
                },
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green
                )
            ) {
                Text(
                    text = "Realiza la conversion",
                    fontWeight = FontWeight.Black
                )
            }
            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                    result = ""
                    valueNumber = ""
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red
                )
            ) {
                Text(
                    text = "Limpiar",
                    fontWeight = FontWeight.Bold
                )
            }


        }


    }
}