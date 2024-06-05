package com.example.tugasakhir.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasakhir.R
import com.example.tugasakhir.ui.theme.BlueColor500
import com.example.tugasakhir.ui.theme.TugasAkhirTheme

@Composable
fun ItemCart(
    image: Int,
    title: String,
    type: String,
    modifier: Modifier = Modifier,
){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(color = MaterialTheme.colorScheme.background)
            .padding(15.dp)
    ){
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(90.dp)
        )
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                ),
                modifier =  Modifier
                    .padding(top= 2.dp, start = 25.dp),
            )
            Box (
                modifier = Modifier
                    .padding(top = 5.dp, start = 25.dp)
                    .background(Color.White)
                    .border(
                        2.dp,
                        BlueColor500,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .width(50.dp)
                    .height(25.dp)

            ){
                Text(
                    text = type,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Medium,
                        color = BlueColor500,
                        fontSize = 12.sp
                    ),
                    modifier = modifier
                        .align(Alignment.Center)

                )
            }
        }
        Icon(
            imageVector = Icons.Default.Delete ,
            contentDescription = "Delete Item",
            tint = BlueColor500,
            modifier= Modifier
                .padding(start = 105.dp)
                .align(Alignment.Bottom)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ItemCartPreview() {
    TugasAkhirTheme{
        ItemCart(
            image = R.drawable.sepeda1,
            title = "Sepeda Listrik",
            type = "Biru")
    }
}