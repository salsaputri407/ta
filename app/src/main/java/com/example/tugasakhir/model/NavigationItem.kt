package com.example.tugasakhir.model

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.tugasakhir.navigation.Screen

data class NavigationItem (
    val title: String,
    val iconSelected: Painter,
    val iconUnselected: Painter,
    val screen: Screen
)