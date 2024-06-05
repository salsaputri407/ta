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
import com.example.tugasakhir.view.components.ItemCart


@Composable
fun CartItemScreen(
    modifier: Modifier = Modifier,
    navigateToDetailCheckoutScreen: () -> Unit = {}
) {
    Column(modifier = modifier) {
        TopAppBar()
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(Color.LightGray)
        )
        Column(
            modifier = Modifier
                .padding(vertical = 20.dp)
                .verticalScroll(rememberScrollState())
                .weight(1f)
        ) {
            CartItemContent()
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(Color.LightGray)
        )
        Column(
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 20.dp)
        ) {
            ActionButton(
                text = stringResource(id = R.string.button_bermain),
                onClick = { navigateToDetailCheckoutScreen() }
            )
        }
    }
}

@Composable
fun CartItemContent() {
    ItemCart(
        image = R.drawable.sepeda1,
        title = "Sepeda Litrik",
        type = "Biru",
    )
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
                text = stringResource(R.string.screen_keranjang),
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                )
            )
        })
}

@Preview(showBackground = true)
@Composable
fun CartItemContentPreview() {
    TugasAkhirTheme {
        CartItemContent()
    }
}

@Preview(showBackground = true)
@Composable
fun CartItemScreenPreview() {
    TugasAkhirTheme {
        CartItemScreen()
    }
}