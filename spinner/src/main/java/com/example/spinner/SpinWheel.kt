package com.example.spinner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.spinner.state.rememberSpinnerState
import com.example.spinner.ui.theme.TugasAkhirTheme
import kotlinx.coroutines.launch
import com.example.spinner.view.Spinner

class SpinWheel : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TugasAkhirTheme {
                SpinnerApp()
            }
        }
    }
}

@Composable
fun SpinnerApp(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val textList by remember {
            mutableStateOf(
                listOf("50", "25", "LOSE", "100", "LOSE", "50", "25", "LOSE")
            )
        }

        val state = rememberSpinnerState()
        val scope = rememberCoroutineScope()

        Spinner(
            state = state,
            onClick = { scope.launch { state.animate { pieIndex -> } } }
        ) { pieIndex ->
            Text(text = textList[pieIndex])
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SpinnerPreview() {
    TugasAkhirTheme {
        SpinnerApp()
    }
}