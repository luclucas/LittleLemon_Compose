package com.lulu.estudo_compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun LoginLayout(){

    var text by remember { mutableStateOf(TextFieldValue("")) }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        Image(painter = painterResource(id = R.drawable.littlelemonlogo), contentDescription = "Logo Lemon")

        TextField(value = text, onValueChange = {text = it},
        label = { Text(text = "E-mail", color = Color.Blue)},
        colors = TextFieldDefaults.textFieldColors(backgroundColor = colorResource(id = R.color.background_textfields)),
        modifier = Modifier.padding(20.dp))

        OutlinedTextField(value = text, onValueChange = {text = it},
            label = { Text(text = "Password", color = Color.Blue)},
            colors = TextFieldDefaults.textFieldColors(backgroundColor = colorResource(id = R.color.background_textfields)))
    }
}
