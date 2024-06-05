package com.example.tugasakhir.view.screen

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.commandiron.spin_wheel_compose.SpinWheel
import com.commandiron.spin_wheel_compose.SpinWheelDefaults
import com.commandiron.spin_wheel_compose.state.rememberSpinWheelState
import com.example.tugasakhir.ui.theme.TugasAkhirTheme
import com.example.tugasakhir.view.components.ActionButton

@Composable
fun WheelspinScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Selamat Datang!"
            )
            Row {
                Text(text = "0")
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = null
                )
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Column(
            modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp, vertical = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Spin the Wheel",
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Kumpulkan point dengan 2 kali kesempatan dan tukar pointmu dengan waktu bermain gratis",
                textAlign = TextAlign.Center,
                fontSize = 12.sp
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Column (
            modifier= Modifier
                .padding(20.dp)
                .weight(1f)
        ) {
            Wheelspin()
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(2.dp)
            .background(Color.LightGray))
        Column (modifier= Modifier.padding(horizontal = 30.dp, vertical = 20.dp)) {
            ActionButton(
                onClick = {},
                text = "Spin"
            )
        }
    }
}

@Composable
fun Wheelspin(
    modifier: Modifier = Modifier
) {
    val textList by remember {
        mutableStateOf(
            listOf(
                "50",
                "25",
                "LOSE",
                "100",
                "LOSE",
                "50",
                "25",
                "LOSE"
            )
        )
    }
    SpinWheel(
        modifier = modifier,
        state = rememberSpinWheelState(
            pieCount = 8,
            durationMillis = 5000,
            delayMillis = 200,
            rotationPerSecond = 2f,
            easing = LinearOutSlowInEasing,
            startDegree = 90f,
            resultDegree = 212f
        ),
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
            fontSize = 20.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WheelspinPreview() {
    TugasAkhirTheme {
        Wheelspin()
    }
}

@Preview(showBackground = true)
@Composable
private fun WheelspinScreenPreview() {
    TugasAkhirTheme {
        WheelspinScreen()
    }
}