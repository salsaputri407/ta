package com.example.tugasakhir.view.screen.detail

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasakhir.R
import com.example.tugasakhir.ui.theme.BlueColor500
import com.example.tugasakhir.view.components.ActionButton

@Composable
fun DetailBarangScreen(

){}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailBarangContent(
    @DrawableRes image: Int,
    title: String,
    onBackClick: () -> Unit,
    onAddToCart: (count: Int) -> Unit,
    modifier: Modifier = Modifier,
){
    Column {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.background,
                navigationIconContentColor = MaterialTheme.colorScheme.primary
            ),
            navigationIcon = {
                Icon(
                    modifier = modifier
                        .padding(start = 15.dp)
                        .clickable { },
                    imageVector = Icons.Filled.KeyboardArrowLeft,
                    tint = BlueColor500,
                    contentDescription = "Left Navigation Icon"
                )
            },
            title = {
                Text(
                    text = stringResource(R.string.screen_barang),
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                    )
                )
            })
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(2.dp)
            .background(Color.LightGray))
        Column (
            modifier= Modifier
                .padding(20.dp)
                .verticalScroll(rememberScrollState())
                .weight(1f)
        ) {
            Box (
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.background)
            ){
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "image_detail_of_item",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(350.dp)
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
                        .align(Alignment.BottomCenter)
                ){
                    Text(
                        text = title,
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
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(15.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.background)
                    .padding(horizontal = 20.dp, vertical = 15.dp)
            ) {
                Text(
                    text = "Waktu",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                    ))
                Text(
                    text = "15 Menit",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = BlueColor500
                    ))
                Text(
                    text = "Pembayaran",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                    ))
                Row (horizontalArrangement = Arrangement.spacedBy(15.dp)) {
                    Button(
                        onClick = { /*TODO*/ },
                        border = BorderStroke(2.dp, Color.LightGray),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color.LightGray
                        ),
                        modifier = Modifier
                            .wrapContentSize()
                            .height(35.dp)
                    ) {
                        Text(text = "Awal")
                    }
                    Button(
                        onClick = { },
                        border = BorderStroke(2.dp, Color.LightGray),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color.LightGray
                        ),
                        modifier = Modifier
                            .wrapContentSize()
                            .height(35.dp)) {
                        Text(text = "Akhir")

                    }
                }
            }
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(2.dp)
            .background(Color.LightGray))
        Column (modifier= Modifier.padding(horizontal = 30.dp, vertical = 20.dp)) {
            ActionButton(
                onClick = {},
                text = stringResource(id = R.string.button_keranjang))
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun DetailBarangScreenPreview() {
//    TugasAkhirTheme {
//        DetailBarangContent(
//            R.drawable.sepeda1,
//            "Biru",)
//    }
//}