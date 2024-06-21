package com.example.tugasakhir.view.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasakhir.R
import com.example.tugasakhir.ui.theme.BlueColor500
import com.example.tugasakhir.ui.theme.GrayLight500
import com.example.tugasakhir.ui.theme.PastelBlueColor500
import com.example.tugasakhir.ui.theme.TugasAkhirTheme

@Composable
fun BadgeScreen(
    modifier: Modifier = Modifier,
    onButtonClicked: (String) -> Unit,
    navigateToHomeScreen: () -> Unit = {},
) {

    val shareMessage = stringResource(id = R.string.share_message)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .align(Alignment.CenterHorizontally)
                    .padding(20.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.badge),
                    contentDescription = "image_detail_of_item",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(245.dp)
                )
            }
            Text(
                text = "Terima kasih",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,)
            )
            Text(
                text = "Selamat bergabung! Inilah kali pertama Anda bermain Kami tunggu bermain selanjutnya",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium.copy(
                    color = GrayLight500,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,),
                modifier = Modifier.padding(horizontal = 45.dp, vertical = 10.dp)
            )
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(PastelBlueColor500)
        )

        Column (
            modifier = Modifier
                .background(Color.White)
                .padding(horizontal = 30.dp, vertical = 20.dp)
        ){
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(45.dp),
            ){
                Button(
                    onClick = {onButtonClicked(shareMessage)},
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = BlueColor500,
                    ),
                    modifier= Modifier.size(140.dp,50.dp)
                )
                { Text(
                    text = "Bagikan",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,)) }
                Button(
                    onClick = {navigateToHomeScreen()},
                    border = BorderStroke(2.dp, BlueColor500),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.background,
                        contentColor = BlueColor500
                    ),
                    modifier= Modifier.size(140.dp,50.dp))
                { Text(
                    text = "Home",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,)) }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BadgeScreemPreview() {
    TugasAkhirTheme {
        BadgeScreen(onButtonClicked = {})
    }
}