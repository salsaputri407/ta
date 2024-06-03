package com.example.timer

import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.timer.ui.theme.TugasAkhirTheme
import com.example.timer.view.TimerView

class Timer : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TugasAkhirTheme {
                TransparentStatusBar(windows = window)
                TimerApp()
            }
        }
    }
}

@Composable
fun TimerApp() {
    Column (modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()){
        TimerView()
    }
}

@Composable
fun TransparentStatusBar(windows: Window)=
    MaterialTheme {
        windows.statusBarColor = MaterialTheme.colorScheme.surface.toArgb()
        windows.navigationBarColor = MaterialTheme.colorScheme.surface.toArgb()

        @Suppress("DEPRECATION")
        if (MaterialTheme.colorScheme.surface.luminance() > 0.5f) {
            windows.decorView.systemUiVisibility = windows.decorView.systemUiVisibility or
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        @Suppress("DEPRECATION")
        if (MaterialTheme.colorScheme.surface.luminance() > 0.5f) {
            windows.decorView.systemUiVisibility = windows.decorView.systemUiVisibility or
                    View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
        }
    }

@Preview("Light Theme", widthDp = 360, heightDp = 640, showBackground = true)
@Composable
fun TugasAkhirPreview(){
    TugasAkhirTheme {
        TimerApp()
    }
}
