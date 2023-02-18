package com.lulu.estudo_compose.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun OrderLayout() {
    
}

@Composable
fun Elements(){
//    var cont by rememberSaveable(inputs = ) {
//        mutableStateOf(0)
//    }
    
    Column(
        Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Greek Salad", fontWeight = FontWeight.Bold)
        
        Row() {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Remove, contentDescription = "Icon Remove")
            }
            //Text(text = )
            
        }
        
    }
}