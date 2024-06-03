package com.example.tugasakhir.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugasakhir.ui.theme.BlueColor500
import com.example.tugasakhir.ui.theme.TugasAkhirTheme

@Composable
fun Card(
    modifier: Modifier = Modifier,
){
    Surface (modifier=modifier
        .padding(start = 18.dp, end = 18.dp)){
        Box (
            modifier= modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .clickable(onClick = { })
                .padding(top = 20.dp, bottom = 20.dp, start = 25.dp, end = 25.dp)
                .background(MaterialTheme.colorScheme.background)
        ){
            Row (
                verticalAlignment =  Alignment.CenterVertically,){
                Text(text = "Selamat Datang!")
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End,
                    modifier = modifier
                        .fillMaxWidth()){
                    Text(
                        text = "0",
                    )
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Point",
                        tint = BlueColor500,
                    )
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun NamaCardPreview(){
    TugasAkhirTheme{
        Card()
    }
}