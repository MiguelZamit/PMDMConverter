package com.miguelzamit.signinmiguel.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.miguelzamit.signinmiguel.ui.theme.SignInMiguelTheme

@Composable
fun SignInContent(content: @Composable (modifier: Modifier) -> Unit){
    SignInMiguelTheme {
        Scaffold (
            modifier = Modifier.fillMaxWidth()
        ){ innerPadding ->
            content(Modifier.padding(innerPadding))
        }
    }
}