package com.example.tugasakhir.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasakhir.ui.theme.TugasAkhirTheme

@Composable
fun ChooseReedem(
    time: String,
    point: String,
    modifier: Modifier = Modifier
){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .border(
                3.dp,
                Color.LightGray,
                shape = RoundedCornerShape(9.dp)
            )
            .padding(12.dp)
    ){
        Text(
            text = time,
            style = MaterialTheme.typography.titleSmall.copy(
                color= Color.LightGray,
                fontSize = 12.sp)
        )
        Text(
            text = point,
            style = MaterialTheme.typography.titleSmall.copy(
                color = Color.LightGray,
                fontSize = 12.sp)
        )
    }
}
@Composable
@Preview(showBackground = true)
fun ChooseReedemPreview(){
    TugasAkhirTheme {
        ChooseReedem(
            time = "5 Menit",
            point = "50 Point")
    }
}