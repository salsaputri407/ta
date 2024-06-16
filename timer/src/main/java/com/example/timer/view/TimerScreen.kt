package com.example.timer.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.timer.ui.theme.TugasAkhirTheme
import com.example.timer.utils.Utility
import com.example.timer.utils.Utility.formatTime
import com.example.timer.view.component.TimerButton
import com.example.timer.view.component.TimerIndicator
import com.example.timer.viewModel.MainViewModel

@JvmOverloads
@Composable
fun TimerScreen(
    viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {

    val time by viewModel.time.observeAsState(Utility.TIME_COUNTDOWN.formatTime())
    val progress by viewModel.progress.observeAsState(1.00F)
    val isPlaying by viewModel.isPlaying.observeAsState(false)

    TimerView(time = time, progress = progress, isPlaying = isPlaying) {
        viewModel.handleCountDownTimer()
    }
}

@Composable
fun TimerView(
    time: String,
    progress: Float,
    isPlaying: Boolean,
    optionSelected: () -> Unit = {}
){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Timer",
            color = androidx.compose.ui.graphics.Color.Black,
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            fontFamily = FontFamily.Default

        )

        TimerIndicator(
            Modifier.padding(top = 50.dp),
            progress = progress,
            time = time,
            size = 250,
            stroke = 12
        )

        TimerButton(

            modifier = Modifier
                .padding(top = 70.dp)
                .size(70.dp),
            isPlaying = isPlaying
        ) {
            optionSelected()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TimeViewPreview() {
    TugasAkhirTheme {
        TimerView(
            time = Utility.TIME_COUNTDOWN.formatTime(),
            progress = 1.00F,
            isPlaying = false)
    }
}