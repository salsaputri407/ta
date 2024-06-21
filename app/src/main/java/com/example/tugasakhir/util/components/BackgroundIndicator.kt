package com.example.tugasakhir.util.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.tugasakhir.ui.theme.BlueColor500
import com.example.tugasakhir.ui.theme.TugasAkhirTheme

@Composable
fun BackgroundIndicator(
    progress: Float,
    modifier: Modifier = Modifier,
    foregroundColor: Color = BlueColor500,
    backgroundColor: Color = BlueColor500.copy(alpha = .25f),
    strokeWidth: Dp = ProgressIndicatorDefaults.CircularStrokeWidth,
) {
    Box(modifier) {
        CircularProgressIndicator(
            progress = progress,
            modifier = Modifier.fillMaxSize(),
            color = foregroundColor,
            strokeWidth = strokeWidth,
        )
        CircularProgressIndicator(
            progress = 1f,
            modifier = Modifier.fillMaxSize(),
            color = backgroundColor,
            strokeWidth = strokeWidth,
        )
    }
}

@Preview(
    name = "Light mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    name = "Dark mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun ScreenContentPreview() {
    TugasAkhirTheme {
        Surface {
            BackgroundIndicator(progress = .6f)
        }
    }
}