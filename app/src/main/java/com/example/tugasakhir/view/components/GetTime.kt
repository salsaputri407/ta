package com.example.tugasakhir.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasakhir.ui.theme.BlueColor500
import com.example.tugasakhir.ui.theme.GreenColor500
import com.example.tugasakhir.ui.theme.TugasAkhirTheme

@Composable
fun GetTime(
    modifier: Modifier = Modifier,
){
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(color = GreenColor500)
            .padding(18.dp)
    ) {
        Text(
            text = "Bermain gratis sampai 10 menit!?  Tukar pointmu!",
            style = MaterialTheme.typography.titleMedium.copy(
                color = Color.White,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
            ))
        Icon(
            modifier = modifier.clickable {  },
            imageVector = Icons.Filled.KeyboardArrowRight,
            contentDescription = "Right Navigation",
            tint = Color.White)
    }
}

@Composable
@Preview(showBackground = true)
fun GetTimesPreview() {
    TugasAkhirTheme{
        GetTime()
    }
}