package com.aoeai.rg.common.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush

@Composable
fun background() = Brush.verticalGradient(
    colors = listOf(
        GradientLightPurple,
        GradientLightBlue,
        GradientMediumBlue
    )
)
