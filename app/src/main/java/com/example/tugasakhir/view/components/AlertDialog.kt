package com.example.tugasakhir.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.tugasakhir.R
import com.example.tugasakhir.ui.theme.BlueColor500

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialog(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
) {
    androidx.compose.material3.AlertDialog(
        onDismissRequest = onDismiss
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .clip(RoundedCornerShape(8.dp))
                .background(color = MaterialTheme.colorScheme.background)
                .size(320.dp, 350.dp)
                .padding(5.dp)
        ) {
            Text(
                text = "Selamat",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Medium
                )
            )
            Text(
                text = "anda mendapat bonus waktu 5 meni",
                style = MaterialTheme.typography.titleSmall
            )
            Image(
                painter = painterResource(id = R.drawable.time),
                contentDescription = "reward"
            )
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    BlueColor500
                )
            ) {
                Text(text = "Bermain")

            }
        }
    }
}

//@Composable
//@Preview(showBackground = true)
//fun PopupMenuPreview() {
//    TugasAkhirTheme{
//        AlertDialog(
//            onDismiss = ,
//        Modifier.padding(8.dp)
//    }
//}