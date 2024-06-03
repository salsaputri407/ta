package com.example.tugasakhir.view.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeSegment(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
){
    Column (modifier){
        SegmentText(title , modifier)
        content()
    }
}