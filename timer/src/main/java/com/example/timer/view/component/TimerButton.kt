package com.example.timer.view.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TimerButton(
    modifier: Modifier = Modifier,
    isPlaying: Boolean,
    optionSelected: ()-> Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 90.dp)
    ) {
        Button(
            onClick = { optionSelected()},
            modifier = Modifier
                .height(70.dp)
                .width(200.dp),
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(Color.Black)
        ){
            val pair = if (!isPlaying){
                "START"
            } else{
                "STOP"
            }
            Text(
                pair,
                fontSize = 20.sp,
                color = Color.White,
                fontFamily = FontFamily.Default
            )
        }
    }
}