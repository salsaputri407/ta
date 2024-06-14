package com.example.tugasakhir.view.screen

import androidx.compose.animation.core.LinearOutSlowInEasing
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.commandiron.spin_wheel_compose.SpinWheel
import com.commandiron.spin_wheel_compose.SpinWheelDefaults
import com.commandiron.spin_wheel_compose.state.SpinWheelState
import com.commandiron.spin_wheel_compose.state.rememberSpinWheelState
import com.example.tugasakhir.R
import com.example.tugasakhir.ui.theme.BlueColor500
import com.example.tugasakhir.ui.theme.GrayLight500
import com.example.tugasakhir.ui.theme.PastelBlueColor500
import com.example.tugasakhir.ui.theme.TugasAkhirTheme
import com.example.tugasakhir.view.components.ActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun WheelSpinScreen(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit,
) {
    val textList by remember { mutableStateOf(
        listOf("50", "25", "LOSE", "100", "LOSE", "50", "25", "LOSE")
    ) }
    val state = rememberSpinWheelState(
        pieCount = 8,
        durationMillis = 5000,
        delayMillis = 200,
        rotationPerSecond = 2f,
        easing = LinearOutSlowInEasing,
        startDegree = 90f,
        resultDegree = 212f
    )
    val scope = rememberCoroutineScope()
    var showOverlay by remember { mutableStateOf(false) }
    var point by remember { mutableIntStateOf(0) }

    Box(
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
        ) {
            Header(onBackClick = {navigateBack()})
            Title()
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(horizontal = 40.dp)
                    .weight(1f)
            ) {
                WheelSpin(
                    state = state,
                    textList = textList
                )
            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(PastelBlueColor500)
            )
            Column (modifier =Modifier.background(Color.White)){
                SpinButton(
                    state = state,
                    scope = scope,
                    getPoint = { point = textList[it].toInt() },
                    showOverlay = { showOverlay = it }
                )
            }
        }
        if (showOverlay) {
            Overlay(
                point = point,
                showOverlay = { showOverlay = it }
            )
        }
    }
}

@Composable
private fun Header(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
) {
    Row(
        verticalAlignment =  Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 20.dp),
    ) {
        Icon(
            modifier = Modifier
                .clickable { onBackClick()},
            imageVector = Icons.Filled.KeyboardArrowLeft,
            tint = BlueColor500,
            contentDescription = "Left Navigation Icon"
        )
        Text(
            text = "Selamat Datang!",
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )
        )
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,){
            Text(text = "0")
            Spacer(modifier = modifier.padding(2.dp))
            Icon(
                painter = painterResource(id = R.drawable.gift),
                contentDescription = null,
                tint = BlueColor500
            )
        }
    }
}

@Composable
fun Overlay(
    modifier: Modifier = Modifier,
    point: Int = 0,
    showOverlay: (Boolean) -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f))
            .padding(30.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = modifier
                .size(400.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
                .padding(horizontal = 25.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Selamat",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp))
            Text(
                text = "Anda mendapatkan $point!",
                style = MaterialTheme.typography.titleMedium.copy(
                    color = GrayLight500,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp))
            Image(
                painter = painterResource(R.drawable.point),
                contentDescription = "point"
            )
           Column (modifier= Modifier
               .padding(top = 20.dp)
               .width(150.dp)){
               ActionButton(
                   text = "Terima",
                   onClick = { showOverlay(false) },
               )
           }
        }
    }
}

@Composable
private fun Title(
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp, vertical = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Spin the Wheel",
            style = MaterialTheme.typography.titleMedium.copy(
                color = BlueColor500,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
        ),
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Kumpulkan point dengan 2 kali kesempatan dan tukar pointmu dengan waktu bermain gratis",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium.copy(
                color = GrayLight500,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,)
        )
    }
}

@Composable
private fun SpinButton(
    modifier: Modifier = Modifier,
    state: SpinWheelState = rememberSpinWheelState(),
    scope: CoroutineScope = rememberCoroutineScope(),
    getPoint: (Int) -> Unit = {},
    showOverlay: (Boolean) -> Unit = {}
) {
    Column(
        modifier = modifier.padding(horizontal = 30.dp, vertical = 20.dp)
    ) {
        ActionButton(
            text = "Spin",
            onClick = {
                scope.launch {
                    state.animate { pieIndex ->
                        getPoint(pieIndex)
                        showOverlay(true)
                    }
                }
            },
        )
    }
}

@Composable
private fun WheelSpin(
    modifier: Modifier = Modifier,
    textList: List<String> = listOf(),
    state: SpinWheelState = rememberSpinWheelState()
) {
    SpinWheel(
        modifier = modifier,
        state = state,
        dimensions = SpinWheelDefaults.spinWheelDimensions(
            spinWheelSize = 340.dp,
            frameWidth = 18.dp,
            selectorWidth = 18.dp
        ),
        colors = SpinWheelDefaults.spinWheelColors(
            frameColor = Color(0xFFB2E0FC),
            dividerColor = Color(0xFF76CCFF),
            selectorColor = Color(0xFF3388FF),
            pieColors = listOf(
                Color(0xFF3388FF),
                Color(0xFF76CCFF),
                Color(0xFFFD0233),
                Color(0xFFFFAB00),
                Color(0xFFFD0233),
                Color(0xFF3388FF),
                Color(0xFF76CCFF),
                Color(0xFFFD0233)
            )
        )
    ) { pieIndex ->
        Text(
            text = textList[pieIndex],
            color = Color.DarkGray,
            modifier = modifier
                .offset(
                    x = 2.dp,
                    y = 2.5.dp
                )
                .alpha(0.5f),
            style = MaterialTheme.typography.titleMedium.copy(
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 21.sp,)
        )
        Text(
            text = textList[pieIndex],
            style = MaterialTheme.typography.titleMedium.copy(
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 21.sp,)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun OverlayPreview() {
    TugasAkhirTheme {
        Overlay()
    }
}

@Preview(showBackground = true)
@Composable
private fun HeaderPreview() {
    TugasAkhirTheme {
        Header(onBackClick = {})
    }
}

@Preview(showBackground = true)
@Composable
private fun TitlePreview() {
    TugasAkhirTheme {
        Title()
    }
}

@Preview(showBackground = true)
@Composable
private fun SpinButtonPreview() {
    TugasAkhirTheme {
        SpinButton()
    }
}

@Preview(showBackground = true)
@Composable
private fun WheelSpinPreview() {
    TugasAkhirTheme {
        WheelSpin()
    }
}

@Preview(showBackground = true)
@Composable
private fun WheelspinScreenPreview() {
    TugasAkhirTheme {
        WheelSpinScreen(navigateBack = {})
    }
}