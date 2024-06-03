package com.example.spinner.animate

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.example.spinner.state.SpinnerState
import com.example.spinner.view.SpinnerContent
import com.example.spinner.view.SpinnerFrame
import com.example.spinner.view.SpinnerPies
import com.example.spinner.view.SpinnerSelector
import kotlinx.coroutines.delay

@Composable
internal fun AnimatedSpinner(
    modifier: Modifier,
    state: SpinnerState,
    size: Dp,
    frameWidth: Dp,
    selectorWidth: Dp,
    frameColor: Color,
    dividerColor: Color,
    selectorColor: Color,
    pieColors: List<Color>,
    onClick: () -> Unit,
    content: @Composable BoxScope.(pieIndex: Int) -> Unit
){
    LaunchedEffect(key1 = state.autoSpinDelay) {
        state.autoSpinDelay?.let {
            delay(it)
            state.spin()
        }
    }
    SpinnerSelector(
        modifier = modifier,
        frameSize = size,
        pieCount = state.pieCount,
        selectorWidth = selectorWidth,
        selectorColor = selectorColor,
        rotationDegree = state.rotation.value
    ) {
        SpinnerFrame(
            modifier = modifier,
            frameSize = size - selectorWidth,
            pieCount = state.pieCount,
            frameWidth = frameWidth,
            frameColor = frameColor,
            dividerColor =  dividerColor,
            rotationDegree = state.rotation.value,
            onClick = onClick,
        ) {
            SpinnerPies(
                modifier = modifier,
                spinSize = size - frameWidth - selectorWidth,
                pieCount = state.pieCount,
                pieColors = pieColors,
                rotationDegree = state.rotation.value,
                onClick = onClick
            ){
                SpinnerContent(
                    modifier = modifier,
                    spinSize = size - frameWidth - selectorWidth,
                    pieCount = state.pieCount,
                    rotationDegree = state.rotation.value
                ){
                    content(it)
                }
            }
        }
    }
}
