package com.example.tugasakhir.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun Spinner(
    modifier: Modifier =  Modifier,
    image: Int,
    title: String,
    desc: String,
    navigateToWheelspinScreen: () -> Unit = {}
){
    Row (modifier=modifier.padding(18.dp)){
        Row (
            modifier= modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(color = MaterialTheme.colorScheme.background)
        ){
            Box (
                modifier= modifier
                    .clip(RoundedCornerShape(8.dp, 0.dp, 0.dp, 8.dp))
                    .background(color = BlueColor500)
                    .padding(vertical = 4.dp, horizontal = 8.dp)
            ){
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "spinner",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(90.dp)
                        .padding(4.dp)
                )

            }
            Column(
                modifier =Modifier
                    .padding(start = 8.dp, top = 18.dp))
            {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                    ),
                )
                Text(text = desc,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.secondary
                    ),
                    modifier= modifier
                        .width(215.dp)
                        .padding(top = 2.dp)
                )

            }
            IconButton(
                modifier= Modifier
                    .padding(start = 2.dp, end = 4.dp)
                    .align(Alignment.CenterVertically),
                onClick = navigateToWheelspinScreen
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight ,
                    contentDescription = "right button",
                    tint = BlueColor500,
                )
            }
        }
    }
}

@Composable
@Preview()
fun SpinnerPreview() {
    TugasAkhirTheme{
        Spinner(
            image = R.drawable.spinner,
            title = "Spin the Wheel",
            desc= "Dapatkan tambahan waktu bermain dengan menukarkan point",
        )
    }
}