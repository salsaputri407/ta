package com.example.tugasakhir.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.tugasakhir.view.components.AlertDialog
import com.example.tugasakhir.view.components.ChooseReedem

@Composable
fun ReedemPointScreen(
    modifier: Modifier = Modifier,
    navigateToDetailCheckoutScreen: () -> Unit = {}

){
//    var showDialog by remember { mutableStateOf(false) }
//
//    if (showDialog){
//       AlertDialog(onDismiss = {showDialog=false})
//    }

    Column {
        TopAppBar()
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(2.dp)
            .background(Color.LightGray))
        Column (
            modifier= Modifier
                .verticalScroll(rememberScrollState())
                .weight(1f)
        ) {
            ReedemContent()
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(2.dp)
            .background(Color.LightGray))
        Column (modifier= Modifier.padding(horizontal = 30.dp, vertical = 20.dp)) {
            ActionButton(
                text = stringResource(id = R.string.button_point),
                onClick = {navigateToDetailCheckoutScreen()})
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopAppBar() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            navigationIconContentColor = MaterialTheme.colorScheme.primary
        ),
        navigationIcon = {
            Icon(
                modifier = Modifier
                    .padding(start = 15.dp)
                    .clickable { },
                imageVector = Icons.Filled.KeyboardArrowLeft,
                tint = BlueColor500,
                contentDescription = "Left Navigation Icon"
            )
        },
        title = {
            Text(
                text = stringResource(R.string.screen_tukar_point),
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                )
            )
        })
}

@Composable
fun ReedemContent(){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Text(
            text = "Point yang Dimiliki",
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
            ))
        Text(
            text = stringResource(R.string.required_point, 100),
            style = MaterialTheme.typography.headlineMedium.copy(
                color = BlueColor500,
                fontWeight = FontWeight.Medium,
                fontSize = 35.sp,
            ))
    }
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Text(
            text = stringResource(R.string.detail_time),
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
            ),
            modifier= Modifier.padding(bottom = 7.dp)
        )
        ChooseReedem(
            time = "5 Menit",
            point = "50 Point",
            modifier= Modifier
                .padding(vertical = 10.dp))
        ChooseReedem(
            time = "10 Menit",
            point = "100 Point")
    }
}

@Preview(showBackground = true)
@Composable
fun RedeemPointScreenPreview() {
    TugasAkhirTheme {
        ReedemPointScreen()
    }
}