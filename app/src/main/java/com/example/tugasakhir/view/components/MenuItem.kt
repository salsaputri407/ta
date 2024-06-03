package com.example.tugasakhir.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasakhir.R
import com.example.tugasakhir.model.Menu
import com.example.tugasakhir.ui.theme.BlueColor500
import com.example.tugasakhir.ui.theme.TugasAkhirTheme

@Composable
fun MenuItem(
    menu: Menu,
    modifier: Modifier = Modifier,
){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier= modifier
            .clip(RoundedCornerShape(8.dp))
    ){
        Image(
            painter = painterResource(id = menu.image),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(175.dp)
                .width(175.dp)
        )
        Button(
            onClick = {},
            shape= RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(BlueColor500),
            modifier = modifier
                .padding(10.dp)
        ) {
            Text(
                text = menu.title,
                maxLines = 1,
                style =  MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold),
                fontSize = 14.sp
            )
        }
    }
}



@Composable
@Preview(showBackground = true)
fun MenuItemPreview() {
    TugasAkhirTheme{
        MenuItem(
            menu = Menu(image = R.drawable.menu2, "Mainan Anak"),
            modifier = Modifier.padding(8.dp))
    }
}