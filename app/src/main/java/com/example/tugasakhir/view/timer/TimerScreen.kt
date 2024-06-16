package com.example.tugasakhir.view.timer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugasakhir.R
import com.example.tugasakhir.model.TimerState
import com.example.tugasakhir.ui.theme.BlueColor500
import com.example.tugasakhir.ui.theme.TugasAkhirTheme
import com.example.tugasakhir.util.components.BackgroundIndicator
import com.example.tugasakhir.util.parseInt
import com.example.tugasakhir.view.components.ActionButton

@Composable
fun TimerScreen(
    modifier: Modifier = Modifier,
    timerState: TimerState,
    timerActions: TimerActions,
    timeText: String,
    navigateToBadgeScreen: () -> Unit
) {
    val hour by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(timeText.substringBefore(":")))
    }
    val minute by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(
            TextFieldValue(timeText.substringAfter(":").substringBefore(':')),
        )
    }
    val second by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(timeText.substringAfterLast(":")))
    }

    LaunchedEffect(Unit) {
        timerActions.setHour(hour.text.parseInt())
        timerActions.setMinute(minute.text.parseInt())
        timerActions.setSecond(second.text.parseInt())
        timerActions.setCountDownTimer()
        timerActions.start()
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Center,
    ) {
        Header(
            modifier = Modifier.align(Alignment.TopCenter)
        )
        Timer(
            modifier = Modifier
                .size(268.dp)
                .align(Center),
            timeText = timerState.timeText,
            progress = timerState.progress,
        )

        ActionButton(
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 20.dp)
                .align(Alignment.BottomCenter),
            text = stringResource(id = R.string.button_kembalikan_barang),
            onClick = { navigateToBadgeScreen() },
            enabled = timerState.isDone,
        )
    }
}

@Composable
private fun Header(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 15.dp),
    ) {
        Text(
            text = "0",
            color = Color.Black
        )
        Spacer(modifier = modifier.padding(2.dp))
        Icon(
            painter = painterResource(id = R.drawable.gift),
            contentDescription = null,
            tint = BlueColor500
        )
    }
}

@Composable
private fun Timer(
    modifier: Modifier = Modifier,
    timeText: String,
    progress: Float,
) {
    Box(modifier = modifier) {
        BackgroundIndicator(
            progress = progress,
            modifier = modifier
                .fillMaxSize()
                .scale(scaleX = 1f, scaleY = 1f),
            strokeWidth = 6.dp,
        )
        Text(
            modifier = Modifier.align(Center),
            text = timeText,
            style = MaterialTheme.typography.displayLarge,
            color = Color.Black,
            fontWeight = FontWeight.Light,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TimerScreenPreview() {
    val timerState = remember {
        TimerState(
            timeText = "00:15:00",
            progress = 1f
        )
    }

    val dummyTimerActions = object : TimerActions {
        override fun setHour(hour: Int) {}
        override fun setMinute(minute: Int) {}
        override fun setSecond(second: Int) {}
        override fun setCountDownTimer() {}
        override fun start() {}
    }

    TugasAkhirTheme {
        TimerScreen(
            timerState = timerState,
            timerActions = dummyTimerActions,
            timeText = "00:15:00",
            navigateToBadgeScreen = {}
        )
    }
}