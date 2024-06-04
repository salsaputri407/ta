package com.example.tugasakhir.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasakhir.model.Barang
import com.example.tugasakhir.ui.theme.BabyBlueColor500

@Composable
fun ItemBarang(
    modifier: Modifier = Modifier,
    barang: Barang,
    navigateToDetailBarangScreen : (Long, Int, String) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(color = MaterialTheme.colorScheme.background)
            .padding(5.dp)
    ) {
        Image(
            painter = painterResource(id = barang.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(175.dp)
        )
        Button(
            onClick = { navigateToDetailBarangScreen(barang.id, barang.image, barang.title) },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(BabyBlueColor500),
            modifier = modifier
                .width(150.dp)
                .height(55.dp)
                .padding(10.dp)
        ) {
            Text(
                text = barang.title,
                maxLines = 1,
                style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.Medium
                ),
                fontSize = 14.sp
            )
        }
    }
}