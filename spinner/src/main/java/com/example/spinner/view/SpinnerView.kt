package com.example.spinner.view

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.spinner.state.SpinnerState
import com.example.spinner.state.rememberSpinnerState
import com.example.spinner.animate.AnimatedSpinner

@Composable
fun Spinner(
    modifier: Modifier = Modifier,
    state: SpinnerState = rememberSpinnerState(),
    dimensions: SpinWheelDimensions = SpinWheelDefaults.spinWheelDimensions(),
    colors: SpinWheelColors = SpinWheelDefaults.spinWheelColors(),
    onClick: () -> Unit = {},
    content: @Composable BoxScope.(pieIndex: Int) -> Unit
) {
    AnimatedSpinner(
        modifier = modifier,
        state = state,
        size = dimensions.spinWheelSize().value,
        frameWidth = dimensions.frameWidth().value,
        selectorWidth = dimensions.selectorWidth().value,
        frameColor = colors.frameColor().value,
        dividerColor = colors.dividerColor().value,
        selectorColor = colors.selectorColor().value,
        pieColors = colors.pieColors().value,
        onClick = onClick,
        content = content
    )
}

object SpinWheelDefaults{
    @Composable
    fun spinWheelColors(
        frameColor: Color = Color(0xFFB2E0FC),
        dividerColor: Color = Color(0xFF76CCFF),
        selectorColor: Color = Color(0xFF3388FF),
        pieColors: List<Color> = listOf(
            Color(0xFF3388FF),
            Color(0xFF76CCFF),
            Color(0xFFFD0233),
            Color(0xFFFFAB00),
            Color(0xFFFD0233),
            Color(0xFF3388FF),
            Color(0xFF76CCFF),
            Color(0xFFFD0233)
        )
    ): SpinWheelColors = DefaultSpinWheelColors(
        frameColor = frameColor,
        dividerColor = dividerColor,
        selectorColor = selectorColor,
        pieColors = pieColors
    )

    @Composable
    fun spinWheelDimensions(
        spinWheelSize: Dp = 340.dp,
        frameWidth: Dp = 18.dp,
        selectorWidth: Dp = 18.dp,
    ): SpinWheelDimensions = DefaultSpinWheelDimensions(
        spinWheelSize = spinWheelSize,
        frameWidth = frameWidth,
        selectorWidth = selectorWidth
    )
}

interface SpinWheelColors {
    @Composable
    fun frameColor(): State<Color>
    @Composable
    fun dividerColor(): State<Color>
    @Composable
    fun selectorColor(): State<Color>
    @Composable
    fun pieColors(): State<List<Color>>
}

@Immutable
private class DefaultSpinWheelColors(
    private val frameColor: Color,
    private val dividerColor: Color,
    private val selectorColor: Color,
    private val pieColors: List<Color>
) : SpinWheelColors {

    @Composable
    override fun frameColor(): State<Color> {
        return rememberUpdatedState(frameColor)
    }

    @Composable
    override fun dividerColor(): State<Color> {
        return rememberUpdatedState(dividerColor)
    }

    @Composable
    override fun selectorColor(): State<Color> {
        return rememberUpdatedState(selectorColor)
    }

    @Composable
    override fun pieColors(): State<List<Color>> {
        return rememberUpdatedState(pieColors)
    }
}

interface SpinWheelDimensions {
    @Composable
    fun spinWheelSize(): State<Dp>
    @Composable
    fun frameWidth(): State<Dp>
    @Composable
    fun selectorWidth(): State<Dp>
}

@Immutable
private class DefaultSpinWheelDimensions(
    private val spinWheelSize: Dp,
    private val frameWidth: Dp,
    private val selectorWidth: Dp
) : SpinWheelDimensions {

    @Composable
    override fun spinWheelSize(): State<Dp> {
        return rememberUpdatedState(spinWheelSize)
    }

    @Composable
    override fun frameWidth(): State<Dp> {
        return rememberUpdatedState(frameWidth)
    }

    @Composable
    override fun selectorWidth(): State<Dp> {
        return rememberUpdatedState(selectorWidth)
    }
}