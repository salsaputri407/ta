package com.example.tugasakhir.view.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasakhir.ui.theme.BlueColor500
import com.example.tugasakhir.ui.theme.PastelBlueColor500

@Composable
fun ReedemPoint(
    time: String,
    point: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
){
    Button(
        onClick = { onClick()},
        border = if (selected) BorderStroke(2.dp, BlueColor500) else BorderStroke(2.dp, PastelBlueColor500),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) PastelBlueColor500 else Color.White,
            contentColor = if (selected) BlueColor500 else PastelBlueColor500
        ),
        modifier = Modifier
            .height(35.dp)
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = time,
                style = MaterialTheme.typography.titleSmall.copy(
                    fontSize = 12.sp))
            Text(
                text = point,
                style = MaterialTheme.typography.titleSmall.copy(
                    fontSize = 12.sp))
        }
    }
}