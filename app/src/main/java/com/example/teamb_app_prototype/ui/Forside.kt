package com.example.teamb_app_prototype.ui

import ApparatViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teamb_app_prototype.ui.theme.TeambappprototypeTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.teamb_app_prototype.R
import com.example.teamb_app_prototype.viewmodel.MinStroemViewModel

//Lukas

@Composable
fun Forside(onTilfoejClick: () -> Unit = {}, onApparatClick: () -> Unit = {}) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFF3F2F8))) {

        Text("")

        DageHeader()

        GrafOversigt()

        ApparatOversigt(onTilfoejClick = onTilfoejClick, onApparatClick = onApparatClick)

    }

}

@Composable
fun DageHeader() {
    var valgtDag by remember { mutableStateOf("I dag")}

    val dage = listOf("I dag", "Fredag", "Lørdag", "Søndag", "Mandag")

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        dage.forEach { dag ->
            val linjeBredde by animateDpAsState(
                targetValue = if (dag == valgtDag) 24.dp else 0.dp,
                label = "linjeanimation"
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clickable { valgtDag = dag }
                    .padding(horizontal = 8.dp)
            ) {
                Text(
                    text = dag
                )
                if (dag == valgtDag) {
                    Box(
                        modifier = Modifier
                            .height(2.dp)
                            .width(linjeBredde)
                            .background(Color.Blue)
                    )
                } else {
                    Spacer(modifier = Modifier.height(2.dp))
                }
            }
        }
    }
}

@Composable
fun GrafOversigt(viewModel: MinStroemViewModel = viewModel()) {

    Column(modifier = Modifier
        .height(300.dp)
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {
        Column {
            Text("Elpriser 10/04")
            Image(
                painter = painterResource(id = R.drawable.stroemgraf),
                contentDescription = "graf over el priser",
                modifier = Modifier
                    .width(350.dp)
                    .height(200.dp)
            )
        }
    }

    /*val priser by viewModel.strømpriser.collectAsState()

        LazyColumn(modifier = Modifier.padding(16.dp).height(300.dp)) {
            items(priser) { pris ->
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(text = pris.date, style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = pris.price.toString(), style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = pris.farve.toString(), style = MaterialTheme.typography.bodyMedium)
                }
            }
        }*/

}

@Composable
fun ApparatOversigt(
    viewModel: ApparatViewModel = viewModel(),
    onTilfoejClick: () -> Unit = {},
    onApparatClick: () -> Unit = {}
) {
    val apparater by viewModel.apparater.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            Text(
                text = "Planlæg apparater",
                modifier = Modifier.padding(bottom = 24.dp)
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier
                    .width(350.dp)
                    .height(340.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                itemsIndexed(apparater) {index, apparat ->
                    val isFirst = index == 0
                    val backgroundColor = if (isFirst) Color(0xFFDAEBFF) else Color(0x55bababa)
                    val onClick = {
                        if (isFirst) {
                            onTilfoejClick()
                        } else {
                            onApparatClick()
                        }
                    }


                    Column(
                        modifier = Modifier
                            .size(90.dp)
                            .background(backgroundColor, shape = RoundedCornerShape(16.dp))
                            .clickable { onClick() }
                            .padding(8.dp)
                        ,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = apparat.billedeResId),
                            contentDescription = apparat.navn,
                            modifier = Modifier
                                .size(50.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = apparat.navn, fontSize = 10.sp)
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TeambappprototypeTheme {
        Forside()
    }
}