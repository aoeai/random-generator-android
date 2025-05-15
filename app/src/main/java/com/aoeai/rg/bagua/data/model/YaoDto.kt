package com.aoeai.rg.bagua.data.model

import androidx.compose.ui.graphics.Color

interface YaoDto {

    // 边缘前、后
    val edgeColor: Color
    val middleColor: Color
    val value: Byte
}