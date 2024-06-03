package com.example.tugasakhir.view.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugasakhir.ui.theme.BlueColor500
import com.example.tugasakhir.ui.theme.TugasAkhirTheme

@Composable
fun ActionButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
){
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(BlueColor500),
        enabled= enabled,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            modifier = Modifier.align(Alignment.CenterVertically))
    }
}

@Composable
@Preview()
fun ActionButtonPreview() {
    TugasAkhirTheme {
        ActionButton(
            text = "Masuk Keranjang",
            onClick = {})
    }
}