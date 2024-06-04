package com.example.tugasakhir.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasakhir.R
import com.example.tugasakhir.ui.theme.BlueColor500
import com.example.tugasakhir.ui.theme.TugasAkhirTheme
import com.example.tugasakhir.view.components.ActionButton
import com.example.tugasakhir.view.components.DetailCart
import com.example.tugasakhir.view.components.SegmentText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailCheckContent(
    detailpayment: String,
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
        Column (modifier = Modifier
            .padding(start = 20.dp,end=20.dp, top=15.dp)) {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.background)
                    .padding(20.dp)
            ){
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 5.dp),
                ){
                    Text(
                        text = stringResource(id = R.string.detail_time),
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                        ))
                    Text(
                        text = stringResource(id = R.string.detail_give_time),
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = BlueColor500,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                        ))
                }
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)) {
                    Text(
                        text = stringResource(id = R.string.detail_pembayaran),
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                        ))
                    Text(
                        text = detailpayment,
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = BlueColor500,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                        ))
                }
            }
        }
        SegmentText(title = stringResource(id = R.string.screen_barang))
        Column (
            modifier= Modifier
                .padding(20.dp)
                .verticalScroll(rememberScrollState())
                .weight(1f)
        ) {
            DetailCart(
                image = R.drawable.sepeda1,
                title = "Sepeda Listrik",
                type = "Biru" )
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(2.dp)
            .background(Color.LightGray))
        Column (modifier= Modifier.padding(horizontal = 30.dp, vertical = 20.dp)) {
            ActionButton(text = stringResource(id = R.string.button_bermain)) {
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailCheckoutScreenPreview() {
    TugasAkhirTheme {
        DetailCheckContent(
            detailpayment = "Akhir",)
    }
}