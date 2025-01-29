package com.aoeai.rg.bagua.data

import androidx.compose.ui.graphics.Color

data class YangYaoDto internal constructor(
    override val edgeColor: Color,
    override val middleColor: Color
) : YaoDto {
    override val value: Byte = 1
}
