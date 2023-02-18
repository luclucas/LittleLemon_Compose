package com.lulu.estudo_compose

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/*
* Tem que tomar cuidado com a row para ela não sair do limite da tela
*
* Pode-se fazer um texto ser clicável utilizand o Modifier.clickable
*
* Modified.combinedClickable - consegue lidar com diferentes formas de clique. OnClick, onLongClick...
*
* onDragStarted, onDragStoped
* */


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    var scafState = rememberScaffoldState()
    var scope = rememberCoroutineScope()

    Scaffold(topBar = {TopAppBar(scafState, scope)},
    scaffoldState = scafState,
        drawerContent = { DrawerPanel(scaffoldState = scafState, scope = scope)}
    ) {

        Column {
            UpperPanel()
            LowerPanel()
        }
    }
}




@Composable
fun UpperPanel() {
    Column(
        Modifier
            .fillMaxWidth()
            .background(color = Color.Gray)
            .padding(30.dp), verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {

        RestaurantName(name = stringResource(id = R.string.title))

        CityName(name = stringResource(id = R.string.city))

        Row(Modifier.padding(top = 20.dp, bottom = 20.dp)) {
            DescriptionText()
            ReturnImage()
        }

        ButtonOrder()
    }
}

@Composable
fun RestaurantName(name: String) {
    Text(text = name, fontSize = 32.sp, color = Color.Green)
}

@Composable
fun CityName(name: String) {
    Text(text = name, fontSize = 20.sp, color = colorResource(id = R.color.white))
}

@Composable
fun ButtonOrder() {
    Button(
        onClick = { /*TODO*/ }, border = BorderStroke(1.dp, Color.Red),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.green_lemon))
    ) {
        Text(text = "Order", color = Color.White)
    }
}

@Composable
fun ReturnImage() {
    Image(
        painter = painterResource(id = R.drawable.restaurant), contentDescription = "Restaurant",
        modifier = Modifier.clip(RoundedCornerShape(10.dp)), contentScale = ContentScale.Fit
    )
}

@Composable
fun DescriptionText() {
    Text(
        text = "We're a traditional restaurant, founded in 1900 by Gabriel Valente. We're specialized in ancient food, like dinosaurs and mammoths",
        color = Color.White,
        modifier = Modifier.width(200.dp)
    )
}

//--------------------------------------------------------------------------

@Composable
fun LowerPanel() {
    WeeklySpecial()
    MenuDish()
}

@Composable
fun WeeklySpecial() {
    val context = LocalContext.current
    Card(
        Modifier
            .padding(top = 20.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(), backgroundColor = Color.White
    )
    {
        Text(
            text = "Weekly Special",
            fontSize = 26.sp,
            modifier = Modifier.padding(8.dp),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun MenuDish() {
    val context = LocalContext.current

    Card(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .clickable {
            Toast
                .makeText(context, "Greek", Toast.LENGTH_SHORT)
                .show()
        }, backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column {
                Text(text = "Greek salad", fontSize = 18.sp, fontWeight = FontWeight.Bold)

                Text(
                    text = "The famous Greek salad of crispy lettuce, peppers, olives, our Chicago ...",
                    Modifier
                        .padding(top = 5.dp, bottom = 5.dp)
                        .fillMaxWidth(.75f)
                )

                Text(text = "\$12.99", color = Color.Gray, fontWeight = FontWeight.Bold)
            }

            Image(
                painter = painterResource(id = R.drawable.greeksalad),
                contentDescription = "Greek",
                modifier = Modifier.clip(
                    RoundedCornerShape(10.dp)
                )
            )
        }
    }
}
