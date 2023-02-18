package com.lulu.estudo_compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope

@Composable
fun DrawerPanel(scaffoldState: ScaffoldState, scope:CoroutineScope) {
    List(10){ Text(text = "Item #$it", Modifier.padding(horizontal = 20.dp, vertical = 10.dp))}
}