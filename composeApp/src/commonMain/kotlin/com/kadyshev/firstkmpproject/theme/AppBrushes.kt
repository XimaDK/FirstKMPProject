package com.kadyshev.firstkmpproject.theme

import androidx.compose.ui.graphics.Brush


object AppBrushes {

    val MainGradient = Brush.verticalGradient(
        colors = listOf(
            AppPalette.GradientDark,
            AppPalette.GradientLight
        )
    )
}