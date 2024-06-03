package com.example.tugasakhir.view.screen.item_mainan

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.ShoppingCart
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasakhir.R
import com.example.tugasakhir.model.Mainan
import com.example.tugasakhir.model.dummyMainan
import com.example.tugasakhir.ui.theme.BlueColor500
import com.example.tugasakhir.ui.theme.TugasAkhirTheme
import com.example.tugasakhir.view.components.ItemMainan

@Composable
fun ItemMainanScreen(
    modifier: Modifier = Modifier,
){
    ItemMainanContent(listMainan = dummyMainan)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemMainanContent(
    listMainan: List<Mainan>,
    modifier: Modifier = Modifier,
){
    Column  (
    ){
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.background,
                navigationIconContentColor = MaterialTheme.colorScheme.primary
            ),
            navigationIcon = {
                Icon(
                    modifier= modifier
                        .padding(start = 15.dp)
                        .clickable { },
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    tint = BlueColor500,
                    contentDescription = "Left Navigation Icon",)
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
        Row (
            horizontalArrangement = Arrangement.spacedBy(55.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(vertical = 15.dp, horizontal = 20.dp)
        ) {
            Row (
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically,){
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.background,
                        contentColor = Color.Black),
                    modifier= Modifier
                        .wrapContentSize()
                        .height(30.dp)
                ) {
                    Text(text = "Sepeda Listrik",
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontWeight = FontWeight.Medium
                        ))
                }
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(BlueColor500),
                    modifier= Modifier
                        .wrapContentSize()
                        .height(30.dp)
                ) {
                    Text(text = "Mainan Anak",
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontWeight = FontWeight.Medium
                        ))
                }
            }
            Icon(
                imageVector = Icons.Filled.ShoppingCart ,
                contentDescription = "Keranjang",
                tint = BlueColor500)
        }
        LazyVerticalGrid(
            columns = GridCells.Adaptive(175.dp),
            state = rememberLazyGridState(),
            contentPadding = PaddingValues(15.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier= Modifier
        ){
            items(listMainan, key = {it.title}) { mainan ->
                ItemMainan(mainan =mainan)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ItemMainanScreenPreview() {
    TugasAkhirTheme {
        ItemMainanContent(listMainan = dummyMainan)
    }
}