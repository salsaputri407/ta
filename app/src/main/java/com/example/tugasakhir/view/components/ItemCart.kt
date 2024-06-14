package com.example.tugasakhir.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasakhir.R
import com.example.tugasakhir.ui.theme.BlueColor500
import com.example.tugasakhir.ui.theme.PastelBlueColor500
import com.example.tugasakhir.ui.theme.TugasAkhirTheme

@Composable
fun ItemCart(
    image: Int,
    title: String,
    type: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .border(
                width = 2.dp,
                color = if (selected) BlueColor500 else BlueColor500.copy(alpha = 0.2f),
                shape = RoundedCornerShape(5.dp),
            )
            .background(color = Color.White)
            .padding(horizontal = 10.dp, vertical = 12.dp)

    ){
        IconButton(
            modifier = Modifier,
            onClick = onClick) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = "Selectable Item Icon",
                tint = if (selected) BlueColor500 else BlueColor500.copy(alpha = 0.2f),
            )
        }
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
        )
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
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
            painter = painterResource(id = R.drawable.trash) ,
            contentDescription = "Delete Item",
            tint = BlueColor500,
            modifier = modifier
                .padding(start = 35.dp)
                .align(Alignment.Bottom)
            )
    }
}

@Composable
@Preview(showBackground = true)
fun ItemCartPreview() {
    TugasAkhirTheme{
        var selected by remember { mutableStateOf(false) }
        ItemCart(
            selected = selected,
            image = R.drawable.sepeda1,
            title = "Sepeda Listrik",
            type = "Biru",
            onClick = {selected = !selected} )
    }
}